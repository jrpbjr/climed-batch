package com.clinica.climed.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.clinica.climed.configuration.chuncklet.DoctorItemProcessor;
import com.clinica.climed.configuration.chuncklet.DoctorItemReader;
import com.clinica.climed.configuration.chuncklet.DoctorItemWriter;
import com.clinica.climed.configuration.tasklet.DoctorValidateTasklet;
import com.clinica.climed.dto.DoctorDTO;
import com.clinica.climed.entities.Doctor;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("doctorJob").start(doctorValidateTaskletStep())
				.next(doctorEnriquecimentoChunckletStep(doctorItemReader(), doctorItemProcessor(), doctorItemWriter()))
				.build();

	}
	
	@Bean
	public Step doctorValidateTaskletStep() {
		return stepBuilderFactory
				.get("doctorValidateTaskletStep")
				.tasklet(new DoctorValidateTasklet("doctor-import"))
				.build();
	}
	
	@Bean
	public Step doctorEnriquecimentoChunckletStep(ItemReader<DoctorDTO> doctorItemReader,
			ItemProcessor<DoctorDTO, Doctor> doctorItemProcessor,
			ItemWriter<Doctor> doctorItemWriter) {
		
		return stepBuilderFactory
				.get("doctorEnriquecimentoChunckletStep")
				.<DoctorDTO, Doctor>chunk(5)
				.reader(doctorItemReader)
				.processor(doctorItemProcessor)
				.writer(doctorItemWriter)
				.build();
	}
	
	@Bean
	ItemReader<DoctorDTO> doctorItemReader(){
		return new DoctorItemReader();
	}
	
	@Bean
	public ItemProcessor<DoctorDTO, Doctor> doctorItemProcessor(){
		return new DoctorItemProcessor();
	}
	
	@Bean ItemWriter<Doctor> doctorItemWriter(){
		return new DoctorItemWriter();
	}
	
	
	
	
	

}
