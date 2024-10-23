package com.apptaxi.demo.dto;

import java.util.Date;

import com.apptaxi.demo.model.Status;

import jakarta.persistence.Column;

public class InspeccionPendientesDto {
	Long id;
	Date initDate;
	Status status;
	Date endDate;
	Date vencimiento;
	String name;
	String surname;
	String dni;
	String patente;
	String marca;
	String modelo;
	String archive;
	public InspeccionPendientesDto(Long id, Date initDate, Status status, Date endDate, String name, String surname,
			String dni, String patente, String marca, String modelo,String archive, Date vencimiento) {
		super();
		this.id = id;
		this.initDate = initDate;
		this.status = status;
		this.endDate = endDate;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.archive=archive;
		this.vencimiento=vencimiento;
	}
	public Long getId() {
		return id;
	}
	
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	public String getArchive() {
		return archive;
	}
	public void setArchive(String archive) {
		this.archive = archive;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
