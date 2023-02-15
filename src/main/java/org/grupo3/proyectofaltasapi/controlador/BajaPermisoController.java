package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.BajaPermiso;
import org.grupo3.proyectofaltasapi.modelo.BajaPermisoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
@RequestMapping("/bajas_permisos")
public class BajaPermisoController {
	private final BajaPermisoRepositorio bajaPermisoRepositorio;
	
	public BajaPermisoController(BajaPermisoRepositorio bajaPermisoRepositorio) {
		this.bajaPermisoRepositorio = bajaPermisoRepositorio;
	}
	
	@GetMapping("/todos")
	public List<BajaPermiso> obtenerTodos(){
		return bajaPermisoRepositorio.findAll();
	}
}
