package com.springsimplespasos.universidad.comandos;

import java.math.BigDecimal;

import com.springsimplespasos.universidad.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.modelo.entidades.Aula;
import com.springsimplespasos.universidad.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.modelo.entidades.Direccion;
import com.springsimplespasos.universidad.modelo.entidades.Empleado;
import com.springsimplespasos.universidad.modelo.entidades.Pabellon;
import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.modelo.entidades.Profesor;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.Pizarron;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.TipoEmpleado;

public class ObjetosDummy {

	public static Aula getAula123() {
		return new Aula(null, 123, "24 x 36", 50, Pizarron.PIZARRA_BLANCA);
	}

	public static Aula getAula231() {
		return new Aula(null, 231, "20 x 30", 50, Pizarron.PIZARRA_TIZA);
	}

	public static Aula getAula451() {
		return new Aula(null, 451, "15 x 25", 50, Pizarron.PIZARRA_BLANCA);
	}

	public static Pabellon getPabellonUno() {
		return new Pabellon(null, 450.5, "Pabellon Uno",
				new Direccion("Calle Uno", "1453", "1623", "", "", "Rodriguez Peña"));
	}

	public static Pabellon getPabellonDos() {
		return new Pabellon(null, 750.0, "Pabellon Dos",
				new Direccion("Calle Dos", "584", "1623", "", "", "Rodriguez Peña"));
	}

	public static Carrera getCarreraIngSis() {
		return new Carrera(null, "Ingenieria en Sistemas", 60, 5);
	}

	public static Carrera getCarreraLicTur() {
		return new Carrera(null, "Licenciatura en Turismo", 42, 4);
	}

	public static Persona getAlumnoUno() {
		return new Alumno(null, "Lautaro", "Gimenez", "34562189", new Direccion());
	}

	public static Persona getAlumnoDos() {
		return new Alumno(null, "Laura", "Videla", "32159753", new Direccion());
	}

	public static Persona getProfesorUno() {
		return new Profesor(null, "Horacio", "Laurin", "22695142", new Direccion(), new BigDecimal("25600"));
	}

	public static Persona getProfesorDos() {
		return new Profesor(null, "Ruben", "Gonzalez", "25943608", new Direccion(), new BigDecimal("23500"));
	}

	public static Persona getEmpleadoUno() {
		return new Empleado(null, "Lucrecia", "Dominguez", "30942108", new Direccion(), new BigDecimal("15600"),
				TipoEmpleado.ADMINISTRATIVO);
	}

	public static Persona getEmpleadoDos() {
		return new Empleado(null, "Roberto", "Lugones", "28902674", new Direccion(), new BigDecimal("14250"),
				TipoEmpleado.MANTENIMIENTO);
	}
}
