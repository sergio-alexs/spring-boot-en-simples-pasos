package com.springsimplespasos.universidad.servicios.contratos;

import com.springsimplespasos.universidad.modelo.entidades.Persona;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO {

	Iterable<Persona> findEmpleadosByTipo(TipoEmpleado tipo);

}
