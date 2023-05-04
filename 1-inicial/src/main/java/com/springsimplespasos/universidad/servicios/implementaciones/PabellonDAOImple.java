package com.springsimplespasos.universidad.servicios.implementaciones;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsimplespasos.universidad.modelo.entidades.Pabellon;
import com.springsimplespasos.universidad.repositorios.PabellonRepository;
import com.springsimplespasos.universidad.servicios.contratos.PabellonDAO;

@Service
public class PabellonDAOImple extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {

	public PabellonDAOImple(PabellonRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> buscarPabellonesPorLocalidad(String localidad) {
		return repository.findPabellonsByDireccion_Localidad(localidad);
	}

	@Override
	public Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre) {
		return repository.findPabellonByNombreIgnoreCase(nombre);
	}

	@Override
	public Iterable<Pabellon> findPabellonsByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta) {
		return repository.findPabellonsByFechaAltaBetween(desde, hasta);
	}

}
