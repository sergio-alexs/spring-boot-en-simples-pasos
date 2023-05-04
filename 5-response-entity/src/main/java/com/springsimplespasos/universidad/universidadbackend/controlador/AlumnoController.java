package com.springsimplespasos.universidad.universidadbackend.controlador;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;

@Deprecated
@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class AlumnoController extends PersonaController {

	private final CarreraDAO carreraDAO;

	public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
		super(alumnoDao);
		nombreEntidad = "Alumno";
		this.carreraDAO = carreraDAO;
	}

	/*
	 * @GetMapping public List<Persona> obtenerTodos(){ List<Persona> alumnos =
	 * (List<Persona>) alumnoDao.findAll(); if(alumnos.isEmpty()){ throw new
	 * BadRequestException("No existe alumnos"); } return alumnos; }
	 * 
	 * @GetMapping("/{id}") public Persona obtenerAlumnoPorId(@PathVariable(required
	 * = false) Integer id){ Optional<Persona> oAlumno = alumnoDao.findById(id);
	 * if(!oAlumno.isPresent()) { throw new
	 * BadRequestException(String.format("Alumno con id %d no existe", id)); }
	 * return oAlumno.get(); }
	 * 
	 * @PostMapping public Persona altaAlumno(@RequestBody Persona alumno){ return
	 * alumnoDao.save(alumno); }
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno) {
		Map<String, Object> mensaje = new HashMap<>();
		Persona alumnoUpdate = null;
		Optional<Persona> oAlumno = service.findById(id);
		if (!oAlumno.isPresent()) {
			// throw new BadRequestException(String.format("Alumno con id %d no existe",
			// id));
			mensaje.put("success", Boolean.FALSE);
			mensaje.put("mensaje", String.format("Alumno con id %d no existe", id));
			return ResponseEntity.badRequest().body(mensaje);
		}
		alumnoUpdate = oAlumno.get();
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setApellido(alumno.getApellido());
		alumnoUpdate.setDireccion(alumno.getDireccion());

		mensaje.put("datos", service.save(alumnoUpdate));
		mensaje.put("success", Boolean.TRUE);

		return ResponseEntity.ok(mensaje);
	}

	/*
	 * @DeleteMapping("/{id}") public void eliminarAlumno(@PathVariable Integer id){
	 * alumnoDao.deleteById(id); }
	 */

	@PutMapping("/{idAlumno}/carrera/{idCarrera}")
	public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera) {
		Map<String, Object> mensaje = new HashMap<>();
		Optional<Persona> oAlumno = service.findById(idAlumno);
		if (!oAlumno.isPresent()) {
			// throw new BadRequestException(String.format("Alumno con id %d no existe",
			// idAlumno));
			mensaje.put("success", Boolean.FALSE);
			mensaje.put("mensaje", String.format("Alumno con id %d no existe", idAlumno));
			return ResponseEntity.badRequest().body(mensaje);
		}

		Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
		if (!oCarrera.isPresent()) {
			// throw new BadRequestException(String.format("Carrera con id %d no existe",
			// idCarrera));
			mensaje.put("success", Boolean.FALSE);
			mensaje.put("mensaje", String.format("Carrera con id %d no existe", idCarrera));
			return ResponseEntity.badRequest().body(mensaje);
		}

		Persona alumno = oAlumno.get();
		Carrera carrera = oCarrera.get();

		((Alumno) alumno).setCarrera(carrera);

		mensaje.put("datos", service.save(alumno));
		mensaje.put("success", Boolean.TRUE);

		return ResponseEntity.ok(mensaje);
	}

}
