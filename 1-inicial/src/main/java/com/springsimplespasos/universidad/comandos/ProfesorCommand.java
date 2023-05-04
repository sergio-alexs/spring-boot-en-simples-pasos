package com.springsimplespasos.universidad.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.servicios.contratos.PersonaDAO;
import com.springsimplespasos.universidad.servicios.contratos.ProfesorDAO;

@Component
@Order(6)
public class ProfesorCommand implements CommandLineRunner {

	@Autowired
	@Qualifier(value = "profesorDAOImple")
	private PersonaDAO servicioProfesor;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------- ************ Profesores Command ************ ---------");

		Iterable<Persona> iProfesor = ((ProfesorDAO) servicioProfesor)
				.findProfesoresByCarrera(ObjetosDummy.getCarreraIngSis().getNombre());

		iProfesor.forEach(System.out::println);
	}
}
