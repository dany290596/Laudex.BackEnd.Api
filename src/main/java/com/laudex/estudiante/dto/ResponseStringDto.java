package com.laudex.estudiante.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ResponseStringDto {
	private String mensaje;
	
	private Boolean estatus;
}