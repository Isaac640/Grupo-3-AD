package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.Guardia;
import org.grupo3.proyectofaltasapi.modelo.Profesor;
import org.grupo3.proyectofaltasapi.modelo.ProfesorRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
	private final ProfesorRepositorio profesorRepositorio;
	
	public ProfesorController(ProfesorRepositorio profesorRepositorio) {
		this.profesorRepositorio = profesorRepositorio;
	}
	
	@GetMapping("/**")
	public List<Profesor> obtenerTodos(){
		return profesorRepositorio.findAll();
	}
	
	@GetMapping("/buscarId")
	public Profesor buscarId(@RequestParam(value = "id", defaultValue = "0") int id) {
		return profesorRepositorio.findById(id).get();
	}
}
