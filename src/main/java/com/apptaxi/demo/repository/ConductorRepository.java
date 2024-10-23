package com.apptaxi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apptaxi.demo.model.Conductor;
import com.apptaxi.demo.model.Status;
@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long>{
	public Conductor findByDni(String dni);
	public List<Conductor> findByStatus(Status status);
}
