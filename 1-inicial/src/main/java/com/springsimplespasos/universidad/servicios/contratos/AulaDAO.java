package com.springsimplespasos.universidad.servicios.contratos;

import java.util.Optional;

import com.springsimplespasos.universidad.modelo.entidades.Aula;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.Pizarron;

public interface AulaDAO extends GenericoDAO<Aula> {

	Iterable<Aula> findAulasByPizarron(Pizarron pizarron);

	Iterable<Aula> findAulasByPabellonNombre(String nombre);

	Optional<Aula> findAulaByNroAula(Integer nroAula);

}
