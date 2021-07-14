package com.clinica.climed.configuration.chuncklet;


import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.clinica.climed.dto.DoctorDTO;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoctorItemReader implements ItemReader<DoctorDTO>, StepExecutionListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorItemReader.class);
	private Iterator<DoctorDTO> doctorInIterador;
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		ExecutionContext ec = stepExecution.getJobExecution().getExecutionContext();
		List<DoctorDTO> doctorDtoList = (List<DoctorDTO>) ec.get("doctorDtoList");
		this.doctorInIterador = doctorDtoList.iterator();
		LOGGER.info("Iniciando o READER...");
		
	}
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		LOGGER.info("Finalizando o READER...");
		return ExitStatus.COMPLETED;
	}
	
	@Override
	public DoctorDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(this.doctorInIterador != null && this.doctorInIterador.hasNext()) {
			return this.doctorInIterador.next();
		}
		return null;
	}
	

}
