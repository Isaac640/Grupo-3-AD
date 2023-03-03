package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.AvisoGuardiaRepositorio;
import org.grupo3.proyectofaltasapi.modelo.Guardia;
import org.grupo3.proyectofaltasapi.modelo.GuardiaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guardia")
public class GuardiaController {
	private final GuardiaRepositorio guardiaRepositorio;
	private final AvisoGuardiaRepositorio avisoGuardiaRepositorio;
	
	public GuardiaController(GuardiaRepositorio guardiaRepositorio, AvisoGuardiaRepositorio avisoGuardiaRepositorio) {
		this.guardiaRepositorio = guardiaRepositorio;
		this.avisoGuardiaRepositorio = avisoGuardiaRepositorio;
	}
	
	@GetMapping("/**")
	public List<Guardia> obtenerTodos(){
		return guardiaRepositorio.findAll();
	}
	
	@GetMapping("/buscar")
	public Guardia buscarId(@RequestParam(value = "id", defaultValue = "0") int id) {
		return guardiaRepositorio.findById(id).get();
	}
	
	@PostMapping("/actualizar")
	public boolean actualizarGuardia(@RequestBody Guardia guardia) {	
		guardia.setHorario(obtenerTodos().get(0).getHorario());
		guardia.setAvisosGuardia(null);
		
		if (guardia != null && guardia.getId() != 0) {
			System.out.println(guardia.getEstado());
			guardiaRepositorio.save(guardia);
			return true;
		}
		
		return false;
	}
	
	@PostMapping("/add")
	public boolean crearGuardia(@RequestBody Guardia guardia) {		
		guardia.setHorario(obtenerTodos().get(0).getHorario());
		
		if (guardia != null && guardia.getId() == 0) {
			System.out.println(guardia.getEstado());
			guardiaRepositorio.save(guardia);
			return true;
		}
		
		return false;
	}
	
	@PostMapping("/add/avisoId")
	public boolean crearGuardiaAvisoId(@RequestBody int avisoId) {	
		System.out.println("------------- " + avisoId);
		
		Guardia guardia = new Guardia(avisoGuardiaRepositorio.findById(avisoId).get());
		
		if (guardia != null && guardia.getId() == 0) {
			System.out.println(guardia.getEstado());
			guardiaRepositorio.save(guardia);
			return true;
		}
		
		return false;
	}
	
	@PostMapping("/eliminar")
	public boolean eliminar(@RequestHeader(value = "id", defaultValue = "0") int id) {
		try {
			guardiaRepositorio.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
