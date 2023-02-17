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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
	private final ProfesorRepositorio profesorRepositorio;
	//private EntityManager em;
	
	public LoginController(ProfesorRepositorio profesorRepositorio) {
		this.profesorRepositorio = profesorRepositorio;
		//this.em = Persistence.createEntityManagerFactory("ProyectoFaltasAPI").createEntityManager();
	}
	
	@PostMapping("/**")
	public int greeting(@RequestParam(value = "user") String user, @RequestParam(value = "pass") String pass) {
		if (user == null || pass == null) return 0;
		
		/*
		String jpql = "SELECT p FROM Profesor p WHERE user = :user and password = :pass";
		TypedQuery<Profesor> query = em.createQuery(jpql, Profesor.class);
		
		query.setParameter("user", user);
		query.setParameter("pass", pass);
		
		List<Profesor> profesores = query.getResultList();
		if (profesores.isEmpty()) return 0;
		
		return profesores.get(0).getId();
		*/

		List<Profesor> profesores = profesorRepositorio.findAll();
		var x = profesores.stream().filter(e -> e.getUser().equals(user) && e.getPassword().equals(pass)).toList();
		
		if (x.isEmpty()) return 0;
		
		return x.get(0).getId();
	}
}
