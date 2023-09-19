package com.laudex.estudiante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laudex.estudiante.model.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {
	List<Estudiante> findAll(); 
	
	Estudiante findById(long id);
	
	
}