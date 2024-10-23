package com.apptaxi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptaxi.demo.dto.LoginDto;
import com.apptaxi.demo.dto.RegisterDto;
import com.apptaxi.demo.dto.Response;
import com.apptaxi.demo.model.Conductor;
import com.apptaxi.demo.model.Status;
import com.apptaxi.demo.model.Vehiculo;
import com.apptaxi.demo.repository.ConductorRepository;
import com.apptaxi.demo.repository.VehiculoRepository;

@Service
public class AutenticacionService {
	@Autowired
	ConductorRepository conductorRepo;
	@Autowired
	VehiculoRepository vehiculoRepo;
	public Response register(RegisterDto d) {
		try {
			Conductor c=new Conductor();
			Vehiculo v=new Vehiculo();
			c.setCarnet(c.getCarnet());
			c.setDni(d.getDni());
			c.setName(d.getName());
			c.setPassword(d.getPassword());
			c.setStatus(Status.PENDING);
			c.setSurname(d.getSurname());
			c=conductorRepo.save(c);
			v.setMarca(d.getMarca());
			v.setModelo(d.getModelo());
			v.setPatente(d.getPatente());
			v= vehiculoRepo.save(v);
			c.setVehiculo(v);
			c=conductorRepo.save(c);
			return new Response(true, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false,"Hubo un error al registrarse", null);
		}
		
	}
	public Response login(LoginDto d) {
		try {
			Conductor c=conductorRepo.findByDni(d.getDni());
			if(c==null) {
				return new Response(false,"DNI y contraseña incorrectas", null);
			}
			if(c.getPassword().equals(d.getPassword())) {
				return new Response(true,"", null);
			}
			return new Response(false,"DNI y contraseña incorrectas",d);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false,"Hubo un error al registrarse", null);
		}
		
	}
}
