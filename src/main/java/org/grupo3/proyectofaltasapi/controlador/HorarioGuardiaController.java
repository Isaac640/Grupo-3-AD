package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.HorarioGuardia;
import org.grupo3.proyectofaltasapi.modelo.HorarioGuardiaRepositorio;
import org.grupo3.proyectofaltasapi.modelo.Profesor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horarioGuardia")
public class HorarioGuardiaController {
	private final HorarioGuardiaRepositorio horarioGuardiaRepositorio;
	
	public HorarioGuardiaController(HorarioGuardiaRepositorio horarioGuardiaRepositorio) {
		this.horarioGuardiaRepositorio = horarioGuardiaRepositorio;
	}
	
	@GetMapping("/**")
	public List<HorarioGuardia> obtenerTodos(){
		return horarioGuardiaRepositorio.findAll();
	}
	
	@GetMapping("/buscar")
	public List<HorarioGuardia> buscarId(@RequestParam(value = "profesorId", defaultValue = "0") int profesorId) {
		return horarioGuardiaRepositorio.findAll().stream().filter(e -> e.getProfesor().getId() == profesorId).toList();
	}
}
