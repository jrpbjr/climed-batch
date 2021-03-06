package com.clinica.climed.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
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
	
	public Doctor() {
		super();
	}
	
	

	public Doctor(Long id, String name, String rg, String cpf, String crm, Double percentage, String address,
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
