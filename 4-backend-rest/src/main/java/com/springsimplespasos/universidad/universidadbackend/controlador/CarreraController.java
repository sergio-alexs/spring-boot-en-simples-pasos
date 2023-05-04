package com.springsimplespasos.universidad.universidadbackend.controlador;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraDAO> {

	public CarreraController(CarreraDAO service) {
		super(service);
		nombreEntidad = "Carrera";
	}

	@GetMapping("/{codigo}")
	public Carrera obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id) {
		Optional<Carrera> oCarrera = service.findById(id);
		if (!oCarrera.isPresent()) {
			throw new BadRequestException(String.format("La carrera con id %d no existe", id));
		}
		return oCarrera.get();
	}

	@PostMapping
	public Carrera altaCarrera(@RequestBody Carrera carrera) {
		if (carrera.getCantidadAnios() < 0) {
			throw new BadRequestException("El campo cantida de años no puede ser negativo");
		}
		if (carrera.getCantidaMaterias() < 0) {
			throw new BadRequestException("El campo cantida de materias no puede ser negativo");
		}
		return service.save(carrera);
	}

	@PutMapping("/{id}")
	public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) {
		Carrera carreraUpdate = null;
		Optional<Carrera> oCarrera = service.findById(id);
		if (!oCarrera.isPresent()) {
			throw new BadRequestException(String.format("La carrera con id %d no existe", id));
		}
		carreraUpdate = oCarrera.get();
		carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
		carreraUpdate.setCantidaMaterias(carrera.getCantidaMaterias());
		return service.save(carreraUpdate);
	}

	@DeleteMapping("/{id}")
	public void eliminarCarrera(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
