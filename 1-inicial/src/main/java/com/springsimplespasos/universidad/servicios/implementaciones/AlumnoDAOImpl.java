package com.springsimplespasos.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.repositorios.AlumnoRepository;
import com.springsimplespasos.universidad.repositorios.PersonaRepository;
import com.springsimplespasos.universidad.servicios.contratos.AlumnoDAO;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

	public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
		return ((AlumnoRepository) repository).buscarAlumnosPorNombreCarrera(nombre);
	}
}
