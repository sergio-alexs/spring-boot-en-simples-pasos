package com.springsimplespasos.universidad.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springsimplespasos.universidad.modelo.entidades.Persona;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository {

	@Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
	Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
