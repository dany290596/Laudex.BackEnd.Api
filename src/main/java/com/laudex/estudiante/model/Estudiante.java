package com.laudex.estudiante.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "estudiante")
@Getter
@Setter
public class Estudiante {
	@Id
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_id_seq")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_id_seq")
    //@SequenceGenerator(name = "estudiante_id_seq", sequenceName = "estudiante_id_seq")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_id_seq")
	//@Column(name = "id", length = 50)
	@SequenceGenerator(name="estudiante_id_seq",
    sequenceName="estudiante_id_seq",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="estudiante_id_seq")
	@Column(name = "id", updatable=false)
	private int id;

	@Column(name = "nombre", length = 50)
    private String nombre;

	@Column(name = "apellidopaterno", length = 50)
    private String apellidopaterno;     

	@Column(name = "apellidomaterno", length = 50)
    private String apellidomaterno;

	@Column(name = "email", length = 50)
    private String email;
}