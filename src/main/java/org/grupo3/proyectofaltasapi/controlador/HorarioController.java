package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.Horario;
import org.grupo3.proyectofaltasapi.modelo.HorarioRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horario")
public class HorarioController {
	private final HorarioRepositorio horarioRepositorio;
	
	public HorarioController(HorarioRepositorio horarioRepositorio) {
		this.horarioRepositorio = horarioRepositorio;
	}
	
	@GetMapping("/todos")
	public List<Horario> obtenerTodos(){
		return horarioRepositorio.findAll();
	}
}
