package com.springsimplespasos.universidad.comandos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springsimplespasos.universidad.modelo.entidades.Aula;
import com.springsimplespasos.universidad.modelo.entidades.enumeradores.Pizarron;
import com.springsimplespasos.universidad.servicios.contratos.AulaDAO;

@Component
@Order(2)
public class AulaCommand implements CommandLineRunner {

	@Autowired
	private AulaDAO servicio;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------- ************ Aulas Command ************ ---------");
		// ---- Buscar Aula por nro

		System.out.println("--- Busqueda de Aula por nro");

		Optional<Aula> oAula = servicio.findAulaByNroAula(231);

		if (oAula.isPresent()) {
			System.out.println(oAula.get().toString());
		}

		// ---- Buscar Aula por pizarron

		System.out.println("--- Busqueda de Aula por pizarron");

		Iterable<Aula> cAula = servicio.findAulasByPizarron(Pizarron.PIZARRA_BLANCA);

		if (!((List<Aula>) cAula).isEmpty()) {
			cAula.forEach(System.out::println);
		}

		System.out.println("---- Busqueda de Aula por pabellon");

		Iterable<Aula> cAulas = servicio.findAulasByPabellonNombre(ObjetosDummy.getPabellonUno().getNombre());

		if (!((List<Aula>) cAulas).isEmpty()) {
			cAulas.forEach(System.out::println);
		}

	}
}
