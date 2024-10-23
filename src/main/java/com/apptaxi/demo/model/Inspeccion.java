package com.apptaxi.demo.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Inspeccion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Date initDate;
	Status status;
	Date endDate;
	Date vencimientoDate;
	public Date getVencimientoDate() {
		return vencimientoDate;
	}
	public void setVencimientoDate(Date vencimientoDate) {
		this.vencimientoDate = vencimientoDate;
	}
	String archive;
	@ManyToOne
	Conductor conductor;
	public Inspeccion() {
		super();
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
	public String getArchive() {
		return archive;
	}
	public void setArchive(String archive) {
		this.archive = archive;
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
}
