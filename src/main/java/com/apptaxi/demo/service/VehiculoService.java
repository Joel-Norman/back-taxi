package com.apptaxi.demo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apptaxi.demo.dto.AccionInpeccionDto;
import com.apptaxi.demo.dto.PerfilDto;
import com.apptaxi.demo.dto.Response;
import com.apptaxi.demo.model.Conductor;
import com.apptaxi.demo.model.Inspeccion;
import com.apptaxi.demo.model.Status;
import com.apptaxi.demo.repository.ConductorRepository;
import com.apptaxi.demo.repository.VehiculoRepository;

@Service
public class VehiculoService {
	@Autowired
	ConductorRepository conductorRepo;
	@Autowired
	VehiculoRepository vehiculoRepo;
	
	
	public Response subirCedula(MultipartFile file,String dni) {
        try {
        	Conductor c=conductorRepo.findByDni(dni);
			if(c==null) {
				return new Response(false,"Hubo un error al subir la cedula.", null);
			}
            Path filePath = Paths.get(dni+"-cedula-"+file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            c.getVehiculo().setCedula(dni+"-cedula-"+file.getOriginalFilename());
            c.setStatus(Status.PENDING);
            vehiculoRepo.save(c.getVehiculo());
            conductorRepo.save(c);
            return new Response(true,"Cedula recibida, espere a que sea aprobado.",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"Hubo un error al subir la cedula.",null);
        }
    }
	
    public Response accionCedula(AccionInpeccionDto d) {
        try {
        	Conductor c=conductorRepo.findById(d.getId()).get();
			if(c==null) {
				return new Response(false,"No se pudo realizar la accion", null);
			}
        	c.setStatus(d.getStatus());
        	conductorRepo.save(c);
            return new Response(true,"Informacion actualizada",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"No se pudo realizar la accion", null);
        }
    }
}
