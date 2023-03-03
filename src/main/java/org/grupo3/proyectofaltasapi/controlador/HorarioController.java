package org.grupo3.proyectofaltasapi.controlador;

import java.util.ArrayList;
import java.util.List;

import org.grupo3.proyectofaltasapi.modelo.Guardia;
import org.grupo3.proyectofaltasapi.modelo.Horario;
import org.grupo3.proyectofaltasapi.modelo.HorarioCentro;
import org.grupo3.proyectofaltasapi.modelo.HorarioRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horario")
public class HorarioController {
	private final HorarioRepositorio horarioRepositorio;
	
	public HorarioController(HorarioRepositorio horarioRepositorio) {
		this.horarioRepositorio = horarioRepositorio;
	}
	
	@GetMapping("/**")
	public List<Horario> obtenerTodos(){
		return horarioRepositorio.findAll();
	}
	
	@GetMapping("/buscar")
	public Horario buscarId(@RequestParam(value = "profesorId", defaultValue = "0") int profesorId, @RequestParam(value = "diaSemana", defaultValue = "0") int diaSemana, @RequestParam(value = "hora", defaultValue = "0") int hora) {
		return (Horario) horarioRepositorio.findAll().stream().filter(e -> e.getProfesor().getId() == profesorId && e.getDiaSemana() == diaSemana && e.getHorariocentro().getId() == hora).toArray()[0];
	}
	
	@GetMapping("/autorrellenar")
	public List<String> autoRellenar(@RequestParam(value = "id", defaultValue = "0") int id, @RequestParam(value ="dia",defaultValue="0") int dia,@RequestParam(value="hora",defaultValue="0") int hora) {
		ArrayList data = new ArrayList();
		
		List<Horario> horarios = horarioRepositorio.findAll();
		System.out.println(id);
		System.out.println(dia);
		System.out.println(hora);
		
		for (Horario horario : horarios) {
			if(horario.getProfesor().getId()==id && horario.getDiaSemana()==dia && horario.getHorariocentro().getId()==hora) {
				System.out.println(horario.getAula());
				System.out.println(horario.getGrupo());

				data.add(horario.getAula()); 
				data.add(horario.getGrupo()); 
			}
		}
		return data;
	}
}
