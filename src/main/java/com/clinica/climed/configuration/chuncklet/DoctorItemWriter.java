package com.clinica.climed.configuration.chuncklet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.climed.entities.Doctor;
import com.clinica.climed.repository.DoctorRepository;
import com.clinica.climed.utils.CsvFileUtilDoctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoctorItemWriter implements ItemWriter<Doctor>, StepExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorItemWriter.class);	
	private CsvFileUtilDoctor CsvSaveDoctor;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		try {
			this.CsvSaveDoctor = new CsvFileUtilDoctor("saveDoctor", false);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("Finalizando o WRITER...");
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		try {
			this.CsvSaveDoctor.closeWriter();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("Finalizando o WRITER...");
				
		return ExitStatus.COMPLETED;
	}

	@Override
	public void write(List<? extends Doctor> doctorOutList) throws Exception {
		
		List<? extends Doctor> savedDoctorList = this.doctorRepository.saveAll(doctorOutList);
		
		savedDoctorList.stream().forEach(doctor ->{
			try {
				this.CsvSaveDoctor.writer(doctor);
			}catch(IOException e) {
				e.printStackTrace();
			}
		});
		
	}

}
