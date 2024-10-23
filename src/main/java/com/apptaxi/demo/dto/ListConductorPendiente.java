package com.apptaxi.demo.dto;


public class ListConductorPendiente {
	Long id;
	String name;
	String surname;
	String dni;
	String patente;
	String marca;
	String modelo;
	String cedula;
	String carnet;
	
	
	public ListConductorPendiente(Long id, String name, String surname, String dni, String patente, String marca,
			String modelo, String cedula, String carnet) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.cedula = cedula;
		this.carnet = carnet;
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	
	
}
