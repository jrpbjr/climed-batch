package com.clinica.climed.entities;

import java.time.Instant;

public class Specialty {
	
	private Long id;
	private String name;
	private boolean enable;
	private Integer orderSpecialty ;
	private Instant createdAt;
	private Instant updatedAt;
	
	public Specialty() {
		super();
	}

	public Specialty(Long id, String name, boolean enable, Integer orderSpecialty, Instant createdAt,
			Instant updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.enable = enable;
		this.orderSpecialty = orderSpecialty;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	

}
