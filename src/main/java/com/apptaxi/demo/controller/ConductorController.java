package com.apptaxi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apptaxi.demo.dto.LoginDto;
import com.apptaxi.demo.dto.RegisterDto;
import com.apptaxi.demo.dto.Response;
import com.apptaxi.demo.service.AutenticacionService;
import com.apptaxi.demo.service.ConductorService;
import com.apptaxi.demo.service.InspeccionService;
import com.apptaxi.demo.service.VehiculoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/conductor")
public class ConductorController {
	@Autowired
	ConductorService condService;
	@Autowired
	VehiculoService vehiService;
	@Autowired
	InspeccionService inspService;
	@PostMapping("/subir/carnet/{dni}")
    public ResponseEntity<?> subirCarnet(@RequestParam("file") MultipartFile file,@PathVariable String dni) {
        return new ResponseEntity(condService.subirCarnet(file, dni),HttpStatus.OK);
    }
	@PostMapping("/subir/cedula/{dni}")
    public ResponseEntity<?> subirCedula(@RequestParam("file") MultipartFile file,@PathVariable String dni) {
        return new ResponseEntity(vehiService.subirCedula(file, dni),HttpStatus.OK);
    }
	@PostMapping("/subir/inspeccion/{dni}")
    public ResponseEntity<?> subirInspeccion(@RequestParam("file") MultipartFile file,@PathVariable String dni) {
        return new ResponseEntity(inspService.saveInspeccion(file, dni),HttpStatus.OK);
    }
	@GetMapping("/inspeciones/{dni}")
    public ResponseEntity<?> listInspecciones(@PathVariable String dni){
        Response response= inspService.listInspeccion(dni);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	@GetMapping("/{dni}")
    public ResponseEntity<?> info(@PathVariable String dni){
        Response response= condService.getPerfil(dni);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
