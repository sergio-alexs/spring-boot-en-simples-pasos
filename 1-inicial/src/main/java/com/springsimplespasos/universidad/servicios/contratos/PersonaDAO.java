package com.springsimplespasos.universidad.servicios.contratos;

import java.util.Optional;

import com.springsimplespasos.universidad.modelo.entidades.Persona;

public interface PersonaDAO extends GenericoDAO<Persona> {

	Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

	Optional<Persona> buscarPorDni(String dni);

	Iterable<Persona> buscarPersonaPorApellido(String apellido);

}
