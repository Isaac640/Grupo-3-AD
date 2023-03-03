package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.AvisoGuardia;
import org.grupo3.proyectofaltasapi.modelo.AvisoGuardiaRepositorio;
import org.grupo3.proyectofaltasapi.modelo.Guardia;
import org.grupo3.proyectofaltasapi.modelo.GuardiaRepositorio;
import org.grupo3.proyectofaltasapi.modelo.Horario;
import org.grupo3.proyectofaltasapi.modelo.HorarioRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aviso")
public class AvisoGuardiaController {
	private final AvisoGuardiaRepositorio avisoGuardiaRepositorio;
	
	public AvisoGuardiaController(AvisoGuardiaRepositorio avisoGuardiaRepositorio) {
		this.avisoGuardiaRepositorio = avisoGuardiaRepositorio;
	}
	
	@GetMapping("/**")
	public List<AvisoGuardia> obtenerTodos(){
		return avisoGuardiaRepositorio.findAll();
	}
	
	@PutMapping("/add")
	public int crearAviso(@RequestBody AvisoGuardia aviso) {
		try {
			avisoGuardiaRepositorio.save(aviso).getIdAviso();
			
			List<AvisoGuardia> avisos = avisoGuardiaRepositorio.findAll();
			return avisos.get(avisos.size() - 1).getIdAviso();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
}
