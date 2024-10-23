package com.apptaxi.demo.dto;

import com.apptaxi.demo.model.Status;
import com.apptaxi.demo.model.Vehiculo;

public class PerfilDto {
	Long id;
	String name;
	String surname;
	String dni;
	Vehiculo vehiculo;
	Status status;
	
	public PerfilDto(Long id, String name, String surname, String dni, Vehiculo vehiculo, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.vehiculo = vehiculo;
		this.status = status;
		
	}
	public PerfilDto() {
		super();
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
