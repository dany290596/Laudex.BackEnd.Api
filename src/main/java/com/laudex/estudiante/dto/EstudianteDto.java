package com.laudex.estudiante.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EstudianteDto {
	private int id;

    private String nombre;

    private String apellidopaterno;     

    private String apellidomaterno;

    private String email;
}