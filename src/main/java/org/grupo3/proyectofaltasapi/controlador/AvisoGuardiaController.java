package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.AvisoGuardia;
import org.grupo3.proyectofaltasapi.modelo.AvisoGuardiaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avisos_guardia")
public class AvisoGuardiaController {
	private final AvisoGuardiaRepositorio avisoGuardiaRepositorio;
	
	public AvisoGuardiaController(AvisoGuardiaRepositorio avisoGuardiaRepositorio) {
		this.avisoGuardiaRepositorio = avisoGuardiaRepositorio;
	}
	
	@GetMapping("/todos")
	public List<AvisoGuardia> obtenerTodos(){
		return avisoGuardiaRepositorio.findAll();
	}
}
