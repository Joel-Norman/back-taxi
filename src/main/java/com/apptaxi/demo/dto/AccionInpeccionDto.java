package com.apptaxi.demo.dto;

import com.apptaxi.demo.model.Status;

public class AccionInpeccionDto {
	Long id;
	Status status;
	
	public AccionInpeccionDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
