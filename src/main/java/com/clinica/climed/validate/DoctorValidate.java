package com.clinica.climed.validate;

import org.apache.commons.lang3.StringUtils;

import com.clinica.climed.dto.DoctorDTO;
import com.clinica.climed.utils.CsvFileUtilDoctor;
import com.clinica.climed.converter.DoctorConverter;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DoctorValidate {
	
	 public DoctorValidate() {}
	 
	 public static List<DoctorDTO> validate(List<DoctorDTO> carroDtoList) throws IOException, ParseException {

	        List<DoctorDTO> validList = new ArrayList<>();
	        List<DoctorDTO> invalidList = new ArrayList<>();

	        carroDtoList.stream().forEach(dto -> {

	            if(isValid(dto)){
	                validList.add(dto);
	            }else{
	                invalidList.add(dto);
	            }
	        });

	        createCsvToInvalidList(invalidList);
	        return validList;
	    }
	 
	 
	 private static void createCsvToInvalidList(List<DoctorDTO> invalidList) throws IOException, ParseException {

	        if(!invalidList.isEmpty()){

	            CsvFileUtilDoctor csvOutInvalid = new CsvFileUtilDoctor("invalid-import-doctor", false);

	            invalidList.stream().forEach(doctor -> {
	                try {
	                    csvOutInvalid.writerError(DoctorConverter.doctorToStringArray(doctor));
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            });

	            csvOutInvalid.closeWriter();
	        }
	    }
	 
	 
	 public void emptyFile(LocalDateTime localDateTime) throws IOException, ParseException {

	        CsvFileUtilDoctor emptyCSV = new CsvFileUtilDoctor("empty-file",false);

	        try {
	            emptyCSV.writerError(DoctorConverter.getErrorToStringArray("Tentativa de Import de arquivo vazio!"));
	            emptyCSV.closeWriter();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 	 
	 
	 private static boolean isValid(DoctorDTO doctorDto) {
		 
				 
	        return StringUtils.isNotBlank(doctorDto.getName());
//	                && StringUtils.isNotBlank(doctorDto.getXXX())
//	                && StringUtils.isNotBlank(doctorDto.getXXX())
//	                && StringUtils.isNotBlank(doctorDto.getXXX())
//	                && StringUtils.isNotBlank(doctorDto.getXXX())
//	                && StringUtils.isNotBlank(doctorDto.getXXX()
//	                		);
	        
	    }

}
