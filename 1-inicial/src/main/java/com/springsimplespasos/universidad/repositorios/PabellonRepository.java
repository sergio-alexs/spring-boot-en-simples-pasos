package com.springsimplespasos.universidad.repositorios;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springsimplespasos.universidad.modelo.entidades.Pabellon;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

	Iterable<Pabellon> findPabellonsByDireccion_Localidad(String localidad);

	Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre);

	Iterable<Pabellon> findPabellonsByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);

}
