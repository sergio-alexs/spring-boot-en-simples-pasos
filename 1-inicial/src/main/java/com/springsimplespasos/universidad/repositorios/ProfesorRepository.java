package com.springsimplespasos.universidad.repositorios;

import org.springframework.data.jpa.repository.Query;

import com.springsimplespasos.universidad.modelo.entidades.Persona;

public interface ProfesorRepository extends PersonaRepository {

	@Query("select p from Profesor p join fetch p.carreras c where c.nombre = ?1")
	// @Query("select p from Profesor p where p.carreras.id = ?1")
	Iterable<Persona> findProfesoresByCarrera(String carrera);

}
