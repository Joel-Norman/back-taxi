package com.apptaxi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apptaxi.demo.model.Vehiculo;
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

}
