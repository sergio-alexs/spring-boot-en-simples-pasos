package com.springsimplespasos.universidad.repositorios;

import org.springframework.data.jpa.repository.Query;

import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.TipoEmpleado;

public interface EmpleadoRepository extends PersonaRepository {

	@Query("select e from Empleado e where e.tipoEmpleado = ?1")
	Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}
