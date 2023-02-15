package org.grupo3.proyectofaltasapi.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horarioguardias database table.
 * 
 */
@Entity
@Table(name="horarioguardias")
@NamedQuery(name="HorarioGuardia.findAll", query="SELECT h FROM HorarioGuardia h")
public class HorarioGuardia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="dia_semana")
	private int diaSemana;

	private int realizadas;

	//uni-directional many-to-one association to HorarioCentro
	@ManyToOne
	@JoinColumn(name="hora_guardia")
	private HorarioCentro horariocentro;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="profesor")
	private Profesor profesor;

	public HorarioGuardia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiaSemana() {
		return this.diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getRealizadas() {
		return this.realizadas;
	}

	public void setRealizadas(int realizadas) {
		this.realizadas = realizadas;
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