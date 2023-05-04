package com.springsimplespasos.universidad.servicios.implementaciones;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsimplespasos.universidad.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.repositorios.CarreraRepository;
import com.springsimplespasos.universidad.servicios.contratos.CarreraDAO;

@Service
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDAO {

	public CarreraDAOImpl(CarreraRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
		return repository.findCarrerasByNombreContains(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
		return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
		return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
	}

}
