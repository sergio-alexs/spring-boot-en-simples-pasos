package com.springsimplespasos.universidad.universidadbackend.servicios.contratos;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera> {

	Iterable<Carrera> findCarrerasByNombreContains(String nombre);

	Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

	Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}
