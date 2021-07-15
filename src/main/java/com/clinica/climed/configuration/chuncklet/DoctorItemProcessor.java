package com.clinica.climed.configuration.chuncklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

import com.clinica.climed.converter.DoctorConverter;
import com.clinica.climed.dto.DoctorDTO;
import com.clinica.climed.entities.Doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoctorItemProcessor implements ItemProcessor<DoctorDTO, Doctor>, StepExecutionListener {

	private static Logger LOGGER = LoggerFactory.getLogger(DoctorItemProcessor.class);
	
	@Override
	public void beforeStep(StepExecution stepExecution) {	
		LOGGER.info("Iniciando o PROCESSOR...");
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		LOGGER.info("Finalizando o PROCESSOR ...");
		return ExitStatus.COMPLETED;
		
	}

	@Override
	public Doctor process(DoctorDTO doctorDto) throws Exception {
		
		return DoctorConverter.getDoctor(doctorDto);
	}




}
