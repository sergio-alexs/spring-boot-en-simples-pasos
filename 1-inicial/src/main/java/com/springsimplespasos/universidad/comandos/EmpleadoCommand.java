package com.springsimplespasos.universidad.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.TipoEmpleado;
import com.springsimplespasos.universidad.servicios.contratos.EmpleadoDAO;
import com.springsimplespasos.universidad.servicios.contratos.PersonaDAO;

@Component
@Order(5)
public class EmpleadoCommand implements CommandLineRunner {

	@Autowired
	@Qualifier(value = "empleadoDAOImple")
	private PersonaDAO servicioEmpleado;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------- ************ Empleados Command ************ ---------");

		Iterable<Persona> iEmpleado = ((EmpleadoDAO) servicioEmpleado).findEmpleadosByTipo(TipoEmpleado.ADMINISTRATIVO);

		iEmpleado.forEach(System.out::println);
	}
}
