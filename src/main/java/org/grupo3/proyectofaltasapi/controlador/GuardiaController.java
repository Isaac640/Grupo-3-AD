package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.Guardia;
import org.grupo3.proyectofaltasapi.modelo.GuardiaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guardias")
public class GuardiaController {
	private final GuardiaRepositorio guardiaRepositorio;
	
	public GuardiaController(GuardiaRepositorio guardiaRepositorio) {
		this.guardiaRepositorio = guardiaRepositorio;
	}
	
	@GetMapping("/todos")
	public List<Guardia> obtenerTodos(){
		return guardiaRepositorio.findAll();
	}
}
