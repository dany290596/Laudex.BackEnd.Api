package com.laudex.estudiante.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.laudex.estudiante.dto.EstudianteDto;
import com.laudex.estudiante.dto.RequestEstudianteDto;
import com.laudex.estudiante.dto.ResponseObjectDto;
import com.laudex.estudiante.dto.ResponseStringDto;

public interface IEstudianteService {
	List<EstudianteDto> getAll();
	
	public ResponseStringDto create(RequestEstudianteDto dto) throws IOException;
	
	public ResponseObjectDto updateById(long id, RequestEstudianteDto dto) throws IOException;
	
	public ResponseObjectDto getById(long id) throws IOException;
	
	public ResponseStringDto deleteById(long id) throws IOException;
}