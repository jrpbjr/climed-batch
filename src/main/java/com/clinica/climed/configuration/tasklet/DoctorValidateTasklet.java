package com.clinica.climed.configuration.tasklet;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.clinica.climed.dto.DoctorDTO;
import com.clinica.climed.utils.CsvFileUtilDoctor;

public class DoctorValidateTasklet implements Tasklet, StepExecutionListener{
	
	private List<DoctorDTO> doctorDtoList;
	private String fileName;
	
	public DoctorValidateTasklet(String fileName) {
		this.fileName = fileName;
		
	}
	

	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.doctorDtoList = new ArrayList<>();
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		stepExecution
			.getJobExecution()
			.getExecutionContext()
			.put("doctorInList", this.doctorDtoList);
		
		return ExitStatus.COMPLETED;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		CsvFileUtilDoctor csvIn = new CsvFileUtilDoctor(this.fileName, true);
		
		DoctorDTO doctorDto = csvIn.read();
		
		while (doctorDto != null) {
			this.doctorDtoList.add(doctorDto);
			doctorDto = csvIn.read();
		}
		
		csvIn.closeReader();
		
		this.doctorDtoList = DoctorValidate.validade(this.doctorDtoList);
		
		if(doctorDtoList.isEmpty()) {
			throw new RuntimeException("A lista de Doctor está vazia!");
		}
				
		
		return RepeatStatus.FINISHED;
	}

}
