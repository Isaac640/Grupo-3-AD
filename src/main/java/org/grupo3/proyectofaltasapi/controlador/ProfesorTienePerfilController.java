package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.ProfesorTienePerfil;
import org.grupo3.proyectofaltasapi.modelo.ProfesorTienePerfilRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor_tiene_perfil")
public class ProfesorTienePerfilController {
	private final ProfesorTienePerfilRepositorio profesorTienePerfilRepositorio;
	
	public ProfesorTienePerfilController(ProfesorTienePerfilRepositorio profesorTienePerfilRepositorio) {
		this.profesorTienePerfilRepositorio = profesorTienePerfilRepositorio;
	}
	
	@GetMapping("/todos")
	public List<ProfesorTienePerfil> obtenerTodos(){
		return profesorTienePerfilRepositorio.findAll();
	}
}
