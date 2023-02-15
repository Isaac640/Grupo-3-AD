package org.grupo3.proyectofaltasapi.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@Table(name = "horario")
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String aula;

	@Column(name="dia_semana")
	private int diaSemana;

	@Column(name="genera_guardia")
	private byte generaGuardia;

	private String grupo;

	private String materia;

	//uni-directional many-to-one association to HorarioCentro
	@ManyToOne
	@JoinColumn(name="hora")
	private HorarioCentro horariocentro;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="profesor")
	private Profesor profesor;

	public Horario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAula() {
		return this.aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public int getDiaSemana() {
		return this.diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public byte getGeneraGuardia() {
		return this.generaGuardia;
	}

	public void setGeneraGuardia(byte generaGuardia) {
		this.generaGuardia = generaGuardia;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public HorarioCentro getHorariocentro() {
		return this.horariocentro;
	}

	public void setHorariocentro(HorarioCentro horariocentro) {
		this.horariocentro = horariocentro;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}