package com.laudex.estudiante.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
    public OpenAPI api() {
        return new OpenAPI()
        		.info(new Info()
        				.title("API - LAUDEX ESTUDIANTE")
        				.version("0.0.1")
        				.description("La API deberá permitir operaciones CRUD (Crear, Leer, Actualizar,\r\n"
        						+ "Eliminar) para una entidad \"Estudiante\" con campos básicos como id,\r\n"
        						+ "nombre, apellido y email.")
        				.termsOfService("danielbr.estatus@gmail.com"));          
    }  
}