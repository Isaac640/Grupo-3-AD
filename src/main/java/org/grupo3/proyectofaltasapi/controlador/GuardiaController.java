package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

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
	
	@PostMapping("/eliminar")
	public boolean eliminar(@RequestHeader(value = "id", defaultValue = "0") int id) {
		try {
			guardiaRepositorio.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("/add")
	public boolean crearGuardia(@RequestBody Guardia guardia) {		
		guardia.setHorario(obtenerTodos().get(0).getHorario());
		
		if (guardia != null && guardia.getId() == 0) {
			guardiaRepositorio.save(guardia);
			return true;
		}
		
		return false;
	}
}
