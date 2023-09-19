package com.laudex.estudiante.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laudex.estudiante.dto.EstudianteDto;
import com.laudex.estudiante.dto.RequestEstudianteDto;
import com.laudex.estudiante.dto.ResponseObjectDto;
import com.laudex.estudiante.dto.ResponseStringDto;
import com.laudex.estudiante.services.IEstudianteService;

@RestController
@Component
@RequestMapping("/api")
@CrossOrigin(origins = {"*"}, methods={RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class EstudianteController {
	
	@Autowired(required = true) IEstudianteService estudianteService;

	@PostMapping("create")
	public ResponseStringDto create(@RequestBody RequestEstudianteDto dto) throws IOException {
		ResponseStringDto r = estudianteService.create(dto);
		return r;
	}
	
	@PutMapping("updateById")
	public ResponseObjectDto updateById(@RequestParam(value = "id", required = true) long id, @RequestBody RequestEstudianteDto dto) throws IOException {
		ResponseObjectDto r = estudianteService.updateById(id, dto);
		return r;
	}
	
	@GetMapping("getAll")
	public List<EstudianteDto> getAll() {
		return estudianteService.getAll();
	}
	
	@GetMapping("getById")
	public ResponseObjectDto getById(@RequestParam(value = "id", required = true) long id) throws IOException {
		ResponseObjectDto r = estudianteService.getById(id);
		return r;
	}
	
	@DeleteMapping(value = "deleteById/{id}")
	public ResponseStringDto deleteById(@PathVariable("id") Long id) throws IOException {
		ResponseStringDto r = estudianteService.deleteById(id);
		return r;
	}
}