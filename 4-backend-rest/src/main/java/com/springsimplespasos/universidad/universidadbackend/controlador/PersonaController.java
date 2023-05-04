package com.springsimplespasos.universidad.universidadbackend.controlador;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;

public class PersonaController extends GenericController<Persona, PersonaDAO> {

	public PersonaController(PersonaDAO service) {
		super(service);
	}

	@GetMapping("/nombre-apellido")
	public Persona buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido) {
		Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
		if (!oPersona.isPresent()) {
			throw new BadRequestException(
					String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
		}
		return oPersona.get();
	}
}
