package com.springsimplespasos.universidad.universidadbackend.servicios.implementaciones;

import static com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy.carrera01;
import static com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy.carrera03;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.repositorios.CarreraRepository;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;

class CarreraDAOImplTest {

	CarreraDAO carreraDAO;
	CarreraRepository carreraRepository;

	@BeforeEach
	void setUp() {
		carreraRepository = mock(CarreraRepository.class);
		carreraDAO = new CarreraDAOImpl(carreraRepository);
	}

	@Test
	void findCarrerasByNombreContains() {
		// Given
		String nombre = "Ingenieria";
		when(carreraRepository.findCarrerasByNombreContains(nombre))
				.thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

		// When
		List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

		// Then
		assertThat(expected.get(0)).isEqualTo(carrera01(true));
		assertThat(expected.get(1)).isEqualTo(carrera03(true));

		verify(carreraRepository).findCarrerasByNombreContains(nombre);
	}

	@Test
	void findCarrerasByNombreContainsIgnoreCase() {
		// Given
		String nombre = "ingenieria";
		when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
				.thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

		// When
		List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

		// Then
		assertThat(expected.get(0)).isEqualTo(carrera01(true));
		assertThat(expected.get(1)).isEqualTo(carrera03(true));

		verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
	}

	@Test
	void findCarrerasByCantidadAniosAfter() {
		// Given
		int cantidad = 4;
		when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
				.thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

		// When
		List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

		// Then
		assertThat(expected.get(0)).isEqualTo(carrera01(true));
		assertThat(expected.get(1)).isEqualTo(carrera03(true));

		verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
	}

}