package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.Guardia;
import org.grupo3.proyectofaltasapi.modelo.HorarioCentro;
import org.grupo3.proyectofaltasapi.modelo.HorarioCentroRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horarioCentro")
public class HorarioCentroController {
	private final HorarioCentroRepositorio horarioCentroRepositorio;
	
	public HorarioCentroController(HorarioCentroRepositorio horarioCentroRepositorio) {
		this.horarioCentroRepositorio = horarioCentroRepositorio;
	}
	
	@GetMapping("/**")
	public List<HorarioCentro> obtenerTodos(){
		return horarioCentroRepositorio.findAll();
	}
	
	@GetMapping("/buscar")
	public HorarioCentro buscarId(@RequestParam(value = "id", defaultValue = "0") int id) {
		return horarioCentroRepositorio.findById(id).get();
	}
}
