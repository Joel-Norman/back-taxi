package com.apptaxi.demo.dto;

import java.util.Date;

import com.apptaxi.demo.model.Status;


public class ListInspeccionDto {
	Long id;
	Date initDate;
	Status status;
	Date endDate;
	public ListInspeccionDto(Long id, Date initDate, Status status, Date endDate) {
		super();
		this.id = id;
		this.initDate = initDate;
		this.status = status;
		this.endDate = endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getInitDate() {
		return initDate;
	}
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
