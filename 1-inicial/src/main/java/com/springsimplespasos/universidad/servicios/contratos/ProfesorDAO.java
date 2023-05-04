package com.springsimplespasos.universidad.servicios.contratos;

import com.springsimplespasos.universidad.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO {

	Iterable<Persona> findProfesoresByCarrera(String nombre);
}
