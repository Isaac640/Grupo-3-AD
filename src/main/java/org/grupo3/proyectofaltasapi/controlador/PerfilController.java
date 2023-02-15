package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.Perfil;
import org.grupo3.proyectofaltasapi.modelo.PerfilRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {
	private final PerfilRepositorio perfilRepositorio;
	
	public PerfilController(PerfilRepositorio perfilRepositorio) {
		this.perfilRepositorio = perfilRepositorio;
	}
	
	@GetMapping("/todos")
	public List<Perfil> obtenerTodos(){
		return perfilRepositorio.findAll();
	}
}
