package com.apptaxi.demo.service;

import org.springframework.http.MediaType;

import org.springframework.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apptaxi.demo.dto.AccionInpeccionDto;
import com.apptaxi.demo.dto.InspeccionPendientesDto;
import com.apptaxi.demo.dto.ListInspeccionDto;
import com.apptaxi.demo.dto.PerfilDto;
import com.apptaxi.demo.dto.Response;
import com.apptaxi.demo.model.Conductor;
import com.apptaxi.demo.model.Inspeccion;
import com.apptaxi.demo.model.Status;
import com.apptaxi.demo.repository.ConductorRepository;
import com.apptaxi.demo.repository.InspeccionRepository;
import com.apptaxi.demo.repository.VehiculoRepository;

import org.springframework.core.io.Resource;

@Service
public class InspeccionService {
	@Autowired
	InspeccionRepository inspeccionRepo;
	@Autowired
	ConductorRepository conductorRepo;
	@Autowired
	VehiculoRepository vehiculoRepo;
	public Response saveInspeccion(MultipartFile file,String dni) {
		try {
        	Conductor c=conductorRepo.findByDni(dni);
			if(c==null) {
				return new Response(false,"Hubo un error al subir archivo", null);
			}
            Path filePath = Paths.get(dni+"-inspeccion-"+file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            Inspeccion i=new Inspeccion();
            i.setArchive(dni+"-inspeccion-"+file.getOriginalFilename());
            i.setConductor(c);
            i.setInitDate(new Date());
            i.setStatus(Status.PENDING);
            inspeccionRepo.save(i);
            return new Response(true,"Archivo recibido, espere a que sea aprobado.",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"Hubo un error al subir archivo",null);
        }
	}
	public Response listInspeccion(String dni) {
		try {
        	Conductor c=conductorRepo.findByDni(dni);
			if(c==null) {
				return new Response(false,"", null);
			}
            List<Inspeccion> l= inspeccionRepo.findByConductorIdOrderByIdDesc(c.getId());
            return new Response(true,"",l.stream().map(t -> new ListInspeccionDto(t.getId(), t.getInitDate(), t.getStatus(), t.getEndDate())).toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"",null);
        }
	}
	
	
	public Response listInspeccionPendientes() {
        try {
        	List<Inspeccion> l= inspeccionRepo.findByStatus(Status.PENDING);
            return new Response(true,"",l.stream().map(t -> new InspeccionPendientesDto(
            		t.getId(),
            		t.getInitDate(), 
            		t.getStatus(), 
            		t.getEndDate(), 
            		t.getConductor().getName(),
            		t.getConductor().getSurname(),
            		t.getConductor().getDni(),
            		t.getConductor().getVehiculo().getPatente(), 
            		t.getConductor().getVehiculo().getMarca(),
            		t.getConductor().getVehiculo().getModelo(),
            		t.getArchive(),
            		t.getVencimientoDate())).toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"",null);
        }
    }
    public ResponseEntity<Resource> verInspeccionArchivo(String archivo) {
        try {
            Path file = Paths.get(archivo);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                String contentType = Files.probeContentType(file);

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType != null ? contentType : "application/octet-stream"))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    
    public Response accionInspeccionPendientes(AccionInpeccionDto d) {
        try {
        	Inspeccion i= inspeccionRepo.findById(d.getId()).get();
        	i.setEndDate(new Date());
        	i.setStatus(d.getStatus());
        	inspeccionRepo.save(i);
        	return new Response(true,"Inspeccion actualizada",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"No se puso realizar la accion.",null);
        }
    }
}
