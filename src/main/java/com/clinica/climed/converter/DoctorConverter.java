package com.clinica.climed.converter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.clinica.climed.dto.DoctorDTO;
import com.clinica.climed.entities.Doctor;
import com.clinica.climed.utils.DateUtil;
import com.clinica.climed.utils.DoctorUtil;

public class DoctorConverter {
	
	public static String[] getErrorToStringArray(String message) {
        List<String> listOut = new ArrayList<>();
        listOut.add(message);
        listOut.add(DateUtil.getNow());
        return listOut.stream().toArray(String[]::new);
    }
	
	public static String[] carroToStringArray(DoctorDTO doctor) {
        List<String> listOut = new ArrayList<>();
        
//        listOut.add(doctor.getXxx());
//        listOut.add(doctor.getXxx());
//        listOut.add(doctor.getXxx());
//        listOut.add(doctor.getXxx());
//        listOut.add(doctor.getXxx());
//        listOut.add(doctor.getXxx());
//        listOut.add(doctor.getXxx());
        
        listOut.add(DateUtil.getNow());
        return listOut.stream().toArray(String[]::new);
    }
	
	public static Doctor getCarro(DoctorDTO doctorDto) {

		Doctor doctor = new Doctor();
		
//		doctor.setXxx(doctorDto.getXxx());
//		doctor.setXxx(doctorDto.getXxx());
//		doctor.setXxx(doctorDto.getXxx());
//		doctor.setXxx(DoctorUtil.convertToInteger(doctorDto.getXxx()));
//		doctor.setXxx(DoctorUtil.convertToInteger(doctorDto.getXxx()));
//		doctor.setXxx(DoctorUtil.convertToBigDecimal(doctorDto.getXxx()));
//		doctor.setXxx(DoctorUtil.chooseStore(doctorDto.getXxx()));
//		doctor.setXxx(DoctorUtil.calculatePrice(doctorDto.getXxx()));
//		doctor.setXxx(DoctorUtil.calculateDiscount(doctorDto.getXxx()));
//		doctor.setXxx(DateUtil.toDate(LocalDateTime.now()));
		
        return doctor;
    }
	
	

}
