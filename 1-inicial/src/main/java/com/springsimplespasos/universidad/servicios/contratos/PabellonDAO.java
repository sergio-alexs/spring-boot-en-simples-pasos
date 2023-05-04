package com.springsimplespasos.universidad.servicios.contratos;

import java.time.LocalDateTime;
import java.util.Optional;

import com.springsimplespasos.universidad.modelo.entidades.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

	Iterable<Pabellon> buscarPabellonesPorLocalidad(String localidad);

	Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre);

	Iterable<Pabellon> findPabellonsByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);

}
