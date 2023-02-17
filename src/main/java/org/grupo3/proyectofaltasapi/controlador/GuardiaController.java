package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.Guardia;
import org.grupo3.proyectofaltasapi.modelo.GuardiaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guardia")
public class GuardiaController {
	private final GuardiaRepositorio guardiaRepositorio;
	
	public GuardiaController(GuardiaRepositorio guardiaRepositorio) {
		this.guardiaRepositorio = guardiaRepositorio;
	}
	
	@GetMapping("/**")
	public List<Guardia> obtenerTodos(){
		return guardiaRepositorio.findAll();
	}
	
	@GetMapping("/buscarId")
	public Guardia buscarId(@RequestParam(value = "id", defaultValue = "0") int id) {
		return guardiaRepositorio.findById(id).get();
	}
}
