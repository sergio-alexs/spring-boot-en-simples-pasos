package com.springsimplespasos.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.TipoEmpleado;
import com.springsimplespasos.universidad.repositorios.EmpleadoRepository;
import com.springsimplespasos.universidad.repositorios.PersonaRepository;
import com.springsimplespasos.universidad.servicios.contratos.EmpleadoDAO;

@Service
public class EmpleadoDAOImple extends PersonaDAOImpl implements EmpleadoDAO {

	public EmpleadoDAOImple(@Qualifier("empleadoRepository") PersonaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findEmpleadosByTipo(TipoEmpleado tipo) {
		return ((EmpleadoRepository) repository).findEmpleadoByTipoEmpleado(tipo);
	}

}
