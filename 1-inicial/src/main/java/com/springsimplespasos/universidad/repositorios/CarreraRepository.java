package com.springsimplespasos.universidad.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.springsimplespasos.universidad.modelo.entidades.Carrera;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

	// @Query("select c from Carrera c where c.nombre like %?1%")
	Iterable<Carrera> findCarrerasByNombreContains(String nombre);

	// @Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
	Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

	// @Query("select c from Carrera c where c.cantidadAnios > ?1")
	Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}
