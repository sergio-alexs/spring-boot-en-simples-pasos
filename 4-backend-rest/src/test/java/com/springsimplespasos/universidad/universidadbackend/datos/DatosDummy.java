package com.springsimplespasos.universidad.universidadbackend.datos;

import static com.springsimplespasos.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado.ADMINISTRATIVO;
import static com.springsimplespasos.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado.MANTENIMIENTO;

import java.math.BigDecimal;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;

public class DatosDummy {

	public static Carrera carrera01(boolean conId) {
		Carrera carrera = (conId) ? new Carrera(1, "Ingenieria en Sistemas", 50, 5)
				: new Carrera(null, "Ingenieria en Sistemas", 50, 5);
		return carrera;
	}

	public static Carrera carrera02() {
		return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
	}

	public static Carrera carrera03(boolean conId) {
		Carrera carrera = (conId) ? new Carrera(3, "Ingenieria Industrial", 60, 5)
				: new Carrera(null, "Ingenieria Industrial", 60, 5);
		return carrera;
	}

	public static Persona empleado01() {
		return new Empleado(null, "Lautaro", "Lopez", "25174036", new Direccion(), new BigDecimal("46750.70"),
				ADMINISTRATIVO);
	}

	public static Persona empleado02() {
		return new Empleado(null, "Lenadro", "Lopez", "25174630", new Direccion(), new BigDecimal("46750.70"),
				MANTENIMIENTO);
	}

	public static Persona profesor01() {
		return new Profesor(null, "Martin", "Lugone", "33908461", new Direccion(), new BigDecimal("60000.00"));
	}

	public static Persona alumno01() {
		return new Alumno(null, "Jhon", "Benitez", "45233715", new Direccion());
	}

	public static Persona alumno02() {
		return new Alumno(null, "Andres", "Benitez", "45233891", new Direccion());
	}

	public static Persona alumno03() {
		return new Alumno(null, "Joaquin", "Leon", "45233012", new Direccion());
	}

}
