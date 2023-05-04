package com.springsimplespasos.universidad.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springsimplespasos.universidad.modelo.entidades.Aula;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.Pizarron;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

	Iterable<Aula> findAulasByPizarron(Pizarron pizarron);

	Iterable<Aula> findAulasByPabellon_Nombre(String nombre);

	Optional<Aula> findAulaByNroAula(Integer nroAula);

}
