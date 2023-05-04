package com.springsimplespasos.universidad.servicios.implementaciones;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsimplespasos.universidad.modelo.entidades.Aula;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.Pizarron;
import com.springsimplespasos.universidad.repositorios.AulaRepository;
import com.springsimplespasos.universidad.servicios.contratos.AulaDAO;

@Service
public class AulaDAOImple extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {

	public AulaDAOImple(AulaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulasByPizarron(Pizarron pizarron) {
		return repository.findAulasByPizarron(pizarron);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulasByPabellonNombre(String nombre) {
		return repository.findAulasByPabellon_Nombre(nombre);
	}

	@Override
	public Optional<Aula> findAulaByNroAula(Integer nroAula) {
		return repository.findAulaByNroAula(nroAula);
	}

}
