package com.apptaxi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apptaxi.demo.model.Inspeccion;
import com.apptaxi.demo.model.Status;
@Repository
public interface InspeccionRepository extends JpaRepository<Inspeccion, Long>{
	public List<Inspeccion> findByConductorIdOrderByIdDesc(Long id);
	public List<Inspeccion> findByStatus(Status status);
}
