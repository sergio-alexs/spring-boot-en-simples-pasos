package com.springsimplespasos.universidad.servicios.contratos;

import com.springsimplespasos.universidad.modelo.entidades.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera> {

	Iterable<Carrera> findCarrerasByNombreContains(String nombre);

	Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

	Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}
