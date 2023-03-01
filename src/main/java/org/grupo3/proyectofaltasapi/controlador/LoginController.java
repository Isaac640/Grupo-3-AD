package org.grupo3.proyectofaltasapi.controlador;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.grupo3.proyectofaltasapi.modelo.Profesor;
import org.grupo3.proyectofaltasapi.modelo.ProfesorRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
	private final ProfesorRepositorio profesorRepositorio;
	
	public LoginController(ProfesorRepositorio profesorRepositorio) {
		this.profesorRepositorio = profesorRepositorio;
	}
	
	@PostMapping("/**")
	public int greeting(@RequestHeader(value = "user") String user, @RequestHeader(value = "passwd") String passwd) {
		System.out.println(user + "  --  " + passwd);
		
		if (user == null || passwd == null) return 0;

		List<Profesor> profesores = profesorRepositorio.findAll();
		var x = profesores.stream().filter(e -> e.getUser().equalsIgnoreCase(user) && e.getPassword().equals(passwd)).toList();
		
		if (x.isEmpty()) return 0;
		
		return x.get(0).getId();
	}
}