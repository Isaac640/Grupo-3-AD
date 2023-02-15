package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.HorarioGuardia;
import org.grupo3.proyectofaltasapi.modelo.HorarioGuardiaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horarioguardias")
public class HorarioGuardiaController {
	private final HorarioGuardiaRepositorio horarioGuardiaRepositorio;
	
	public HorarioGuardiaController(HorarioGuardiaRepositorio horarioGuardiaRepositorio) {
		this.horarioGuardiaRepositorio = horarioGuardiaRepositorio;
	}
	
	@GetMapping("/todos")
	public List<HorarioGuardia> obtenerTodos(){
		return horarioGuardiaRepositorio.findAll();
	}
}
