package com.springsimplespasos.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.repositorios.PersonaRepository;
import com.springsimplespasos.universidad.repositorios.ProfesorRepository;
import com.springsimplespasos.universidad.servicios.contratos.ProfesorDAO;

@Service
public class ProfesorDAOImple extends PersonaDAOImpl implements ProfesorDAO {

	public ProfesorDAOImple(@Qualifier("profesorRepository") PersonaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findProfesoresByCarrera(String nombre) {
		return ((ProfesorRepository) repository).findProfesoresByCarrera(nombre);
	}

}
