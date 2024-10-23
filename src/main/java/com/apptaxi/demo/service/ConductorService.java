package com.apptaxi.demo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apptaxi.demo.dto.AccionInpeccionDto;
import com.apptaxi.demo.dto.InspeccionPendientesDto;
import com.apptaxi.demo.dto.ListConductorPendiente;
import com.apptaxi.demo.dto.PerfilDto;
import com.apptaxi.demo.dto.Response;
import com.apptaxi.demo.model.Conductor;
import com.apptaxi.demo.model.Inspeccion;
import com.apptaxi.demo.model.Status;
import com.apptaxi.demo.model.Vehiculo;
import com.apptaxi.demo.repository.ConductorRepository;
import com.apptaxi.demo.repository.VehiculoRepository;


@Service
public class ConductorService {
	@Autowired
	ConductorRepository conductorRepo;
	@Autowired
	VehiculoRepository vehiculoRepo;
	public Response getPerfil(String dni) {
		try {
			Conductor c=conductorRepo.findByDni(dni);
			if(c==null) {
				return new Response(false,"Hubo un error al obtener la informacion", null);
			}
			PerfilDto p=new PerfilDto(c.getId(),c.getName(), c.getSurname(), c.getDni(), c.getVehiculo(), c.getStatus());
			
			return new Response(true,"",p);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false,"Hubo un error al obtener la informacion", null);
		}
	}
	
	public Response subirCarnet(MultipartFile file,String dni) {
        try {
        	Conductor c=conductorRepo.findByDni(dni);
			if(c==null) {
				return new Response(false,"Hubo un error al subir el carnet.", null);
			}
            Path filePath = Paths.get(dni+file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            c.setCarnet(dni+file.getOriginalFilename());
            c.setStatus(Status.PENDING);
            conductorRepo.save(c);
            return new Response(true,"Carnet recibido, espere a que sea aprobado.",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"Hubo un error al subir el carnet.",null);
        }
    }
	public Response listConductorPendientes() {
        try {
        	List<Conductor> l= conductorRepo.findByStatus(Status.PENDING);
            return new Response(true,"",l.stream().map(t -> new ListConductorPendiente(
            		t.getId(), t.getName(), t.getSurname(), t.getDni(), t.getVehiculo().getPatente(), t.getVehiculo().getMarca(),
            		t.getVehiculo().getModelo(), t.getVehiculo().getCedula(), t.getCarnet())).toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"",null);
        }
    }
}
