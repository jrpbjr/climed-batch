package com.clinica.climed.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clinica.climed.dto.DoctorDTO;
import com.clinica.climed.entities.Doctor;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CsvFileUtilDoctor {

	private static final String PATH_INPUT_FILE = "csv/fileInput/";
	private static final String PATH_OUTPUT_FILE = "src/main/resources/csv/fileOutput/";
	private CSVReader csvReader;
	private CSVWriter csvWriter;
	private String fileName;
	private File file;
	private FileReader fileReader;
	private FileWriter fileWriter;

	public CsvFileUtilDoctor(String fileName, boolean isInput) {

		if (isInput) {
			this.fileName = PATH_INPUT_FILE + fileName + ".csv";
		} else {
			this.fileName = PATH_OUTPUT_FILE + fileName + "-" + DateUtil.getNow() + "-.csv";
		}
	}

	public DoctorDTO read() throws IOException, CsvValidationException {

		if (this.csvReader == null) {
			getFileToRead();
			getFileReader();
			getCSVReader();
		}

		String[] fields = this.csvReader.readNext();

		if (fields == null) {
			return null;
		}

		List<String> list = Arrays.asList(fields);

		 if(list.size() >= 14){
		 return new DoctorDTO(list.get(0), list.get(1), list.get(2), list.get(3),list.get(4), list.get(5),list.get(6),list.get(7),list.get(8),list.get(9),list.get(10),list.get(11),list.get(12),list.get(13),list.get(14));
		 }

		 return new DoctorDTO(list.toString());

	}

	private void getFileToRead() {

		ClassLoader classLoader = this.getClass().getClassLoader();

		if (this.file == null) {
			String filePath = classLoader.getResource(this.fileName).getFile();
			this.file = new File(filePath);
		}
	}

	private void getFileReader() throws FileNotFoundException {
		if (this.fileReader == null) {
			this.fileReader = new FileReader(this.file);
		}
	}

	private void getCSVReader() {
		if (this.csvReader == null) {
			this.csvReader = new CSVReader(this.fileReader);
		}
	}

	public void closeReader() throws IOException {
		this.csvReader.close();
		this.fileReader.close();
	}

	public void writer(Doctor doctor) throws IOException {

		if (this.csvWriter == null) {
			getFileToWrite();
			getFileWriter();
			getCSVWriter();
		}

		List<String> doctorList = new ArrayList<>();
		doctorList.add(doctor.getId().toString());
		doctorList.add(doctor.getName());
		doctorList.add(doctor.getRg());
		doctorList.add(doctor.getCpf());

//        if(doctor.getXxx() != null){
//            doctorList.add(doctor.getXxx().toString());
//        }
//
//        if(doctor.getXxx() != null){
//            doctorList.add(doctor.getXxx().toString());
//        }
//
//        if(doctor.getXxx() != null){
//            doctorList.add(doctor.getXxx().toString());
//        }
//
//        if(doctor.getXxx() != null){
//            doctorList.add(doctor.getXxx().toString());
//        }
//
//        if(doctor.getXxx() != null){
//            doctorList.add(doctor.getXxx().toString());
//        }
//
//        if(doctor.getXxx() != null){
//            doctorList.add(doctor.getXxx().toString());
//        }

		doctorList.add(DateUtil.getNow());

		this.csvWriter.writeNext(doctorList.stream().toArray(String[]::new));
	}

	public void writerError(String[] doctorError) throws IOException {

		if (this.csvWriter == null) {
			getFileToWrite();
			getFileWriter();
			getCSVWriter();
		}

		this.csvWriter.writeNext(doctorError);
	}

	private void getFileToWrite() throws IOException {
		if (this.file == null) {
			this.file = new File(this.fileName);
			this.file.createNewFile();
		}
	}

	private void getFileWriter() throws IOException {
		if (this.fileWriter == null) {
			this.fileWriter = new FileWriter(this.file, true);
		}
	}

	private void getCSVWriter() {
		if (this.csvWriter == null) {
			this.csvWriter = new CSVWriter(this.fileWriter);
		}
	}

	public void closeWriter() throws IOException {
		this.csvWriter.close();
	}

}
