package com.clinica.climed.dto;

import java.io.Serializable;

import com.clinica.climed.entities.Specialty;

public class SpecialtyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private boolean enable;
	private Integer orderSpecialty;

	public SpecialtyDTO() {
		super();
	}

	public SpecialtyDTO(Long id, String name, boolean enable, Integer orderSpecialty) {
		super();
		this.id = id;
		this.name = name;
		this.enable = enable;
		this.orderSpecialty = orderSpecialty;
	}

	public SpecialtyDTO(Specialty entity) {

		this.id = entity.getId();
		this.name = entity.getName();
		this.enable = entity.isEnable();
		this.orderSpecialty = entity.getOrderSpecialty();

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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Integer getOrderSpecialty() {
		return orderSpecialty;
	}

	public void setOrderSpecialty(Integer orderSpecialty) {
		this.orderSpecialty = orderSpecialty;
	}

}
