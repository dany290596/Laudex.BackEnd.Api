package com.laudex.estudiante.services;
import com.laudex.estudiante.repository.IEstudianteRepository;
import com.laudex.estudiante.utils.MapperUtil;
import com.laudex.estudiante.dto.EstudianteDto;
import com.laudex.estudiante.dto.ResponseStringDto;
import com.laudex.estudiante.model.Estudiante;
import com.laudex.estudiante.dto.RequestEstudianteDto;
import com.laudex.estudiante.dto.ResponseObjectDto;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService implements IEstudianteService {
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public ResponseStringDto create(RequestEstudianteDto dto) throws IOException {
		ResponseStringDto r = new ResponseStringDto();
		
		try {
			
			Estudiante e = new Estudiante();
			e.setNombre(dto.getNombre());
			e.setApellidopaterno(dto.getApellidopaterno());
			e.setApellidomaterno(dto.getApellidomaterno());
			e.setEmail(dto.getEmail());
			
			estudianteRepository.save(e);
			
			r.setEstatus(true);
			r.setMensaje("El estudiante se guardó correctamente.");			
			
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("La solicitud no se proceso correctamente.");
		}
	}
	
	@Override
	public List<EstudianteDto> getAll() {
		return estudianteRepository.findAll().stream().
				map(data -> modelMapper.map(data, EstudianteDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public ResponseObjectDto updateById(long id, RequestEstudianteDto dto) throws IOException {
		try {
			Estudiante e = estudianteRepository.findById(id);
					if(e == null) {	
						ResponseObjectDto o = new ResponseObjectDto();
						o.setMensaje("No existe ningun estudiante con este indentificador.");
						o.setEstatus(false);
			
						return o;
					} else {
						e.setNombre(dto.getNombre());
						e.setApellidopaterno(dto.getApellidopaterno());
						e.setApellidomaterno(dto.getApellidomaterno());
						e.setEmail(dto.getEmail());
						estudianteRepository.save(e);
			
						ResponseObjectDto o = new ResponseObjectDto();
						o.setMensaje("El estudiante se actualizó correctamente.");
						o.setEstatus(true);
			
						return o;
					}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("La solicitud no se proceso correctamente.");
		}
	}
	
	@Override
	public ResponseObjectDto getById(long id) throws IOException {
		try {
			Estudiante e = estudianteRepository.findById(id);
			if(e == null) {	
				ResponseObjectDto o = new ResponseObjectDto();
				o.setMensaje("No existe ningun estudiante con este indentificador.");
				o.setEstatus(false);
				return o;
			} else {
				EstudianteDto dto = new EstudianteDto();
				Estudiante data = estudianteRepository.findById(id);
			
				MapperUtil.map(data, dto);
			
				ResponseObjectDto r = new ResponseObjectDto();
				r.setEstudiante(dto);
				r.setMensaje("La consulta se realizó correctamente.");
				r.setEstatus(true);
				return r;
			}			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("La solicitud no se proceso correctamente.");
		}
	}
	
	@Override
	public ResponseStringDto deleteById(long id) throws IOException {
		try {
			Estudiante e = estudianteRepository.findById(id);
			if(e != null) {								
				ResponseStringDto r = new ResponseStringDto();
				estudianteRepository.deleteById(id);
				r.setEstatus(true);
				r.setMensaje("El estudiante se eliminó correctamente.");	
				return r;
			} else {
				ResponseStringDto r = new ResponseStringDto();
				r.setEstatus(false);
				r.setMensaje("No existe ningun estudiante con este indentificador.");	
				return r;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("La solicitud no se proceso correctamente.");
		}
    }
}