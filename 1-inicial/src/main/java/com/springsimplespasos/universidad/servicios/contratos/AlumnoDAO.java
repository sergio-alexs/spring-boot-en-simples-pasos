package com.springsimplespasos.universidad.servicios.contratos;

import com.springsimplespasos.universidad.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO {

	Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
