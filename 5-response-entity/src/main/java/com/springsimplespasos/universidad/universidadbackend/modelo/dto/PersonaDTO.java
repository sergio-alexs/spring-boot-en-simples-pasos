package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({ @JsonSubTypes.Type(value = AlumnoDTO.class, name = "alumno"),
		@JsonSubTypes.Type(value = ProfesorDTO.class, name = "profesor") })
public abstract class PersonaDTO {

	private Integer id;
	private String nombre;
	private String apellido;
	@Pattern(regexp = "[0-9]+")
	@Size(min = 1, max = 10)
	private String dni;
	private Direccion direccion;

}
