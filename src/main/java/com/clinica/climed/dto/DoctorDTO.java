package com.clinica.climed.dto;

import java.io.Serializable;

import com.clinica.climed.entities.Doctor;

public class DoctorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String rg;
	private String cpf;
	private String crm;
	private Double percentage;
	private String address;
	private String city;
	private String provincie;
	private String postalCode;
	private String houseNumber;
	private String apartmentNumber;
	private String district;
	private String complement;
	private String invalid;
	

	public DoctorDTO(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15) {
		super();
	}
	
	public DoctorDTO(String invalid) {
		super();
		this.invalid = invalid;
	}

	public DoctorDTO(Long id, String name, String rg, String cpf, String crm, Double percentage, String address,
			String city, String provincie, String postalCode, String houseNumber, String apartmentNumber,
			String district, String complement) {
		super();
		this.id = id;
		this.name = name;
		this.rg = rg;
		this.cpf = cpf;
		this.crm = crm;
		this.percentage = percentage;
		this.address = address;
		this.city = city;
		this.provincie = provincie;
		this.postalCode = postalCode;
		this.houseNumber = houseNumber;
		this.apartmentNumber = apartmentNumber;
		this.district = district;
		this.complement = complement;
		
	}
	
	public DoctorDTO(Doctor entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.rg = entity.getRg();
		this.cpf = entity.getCpf();
		this.crm = entity.getCrm();
		this.percentage = entity.getPercentage();
		this.address = entity.getAddress();
		this.city = entity.getCity();
		this.provincie = entity.getProvincie();
		this.postalCode = entity.getPostalCode();
		this.address = entity.getAddress();
		this.city = entity.getCity();
		this.houseNumber = entity.getHouseNumber();
		this.apartmentNumber = entity.getApartmentNumber();
		this.district = entity.getDistrict();
		this.complement = entity.getComplement();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvincie() {
		return provincie;
	}

	public void setProvincie(String provincie) {
		this.provincie = provincie;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

}
