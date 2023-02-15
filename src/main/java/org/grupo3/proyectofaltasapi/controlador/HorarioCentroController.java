package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.HorarioCentro;
import org.grupo3.proyectofaltasapi.modelo.HorarioCentroRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horariocentro")
public class HorarioCentroController {
	private final HorarioCentroRepositorio horarioCentroRepositorio;
	
	public HorarioCentroController(HorarioCentroRepositorio horarioCentroRepositorio) {
		this.horarioCentroRepositorio = horarioCentroRepositorio;
	}
	
	@GetMapping("/todos")
	public List<HorarioCentro> obtenerTodos(){
		return horarioCentroRepositorio.findAll();
	}
}
