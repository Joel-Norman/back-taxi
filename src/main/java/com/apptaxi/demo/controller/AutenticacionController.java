package com.apptaxi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apptaxi.demo.dto.LoginDto;
import com.apptaxi.demo.dto.RegisterDto;
import com.apptaxi.demo.dto.Response;
import com.apptaxi.demo.service.AutenticacionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AutenticacionController {
	@Autowired
	AutenticacionService authService;
	@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto dto){
        Response response= authService.register(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto){
        Response response= authService.login(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
