package org.grupo3.proyectofaltasapi.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the guardias database table.
 * 
 */
@Entity
@Table(name="guardias")
@NamedQuery(name="Guardia.findAll", query="SELECT g FROM Guardia g")
public class Guardia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String aula;

	@Column(name="dia_semana")
	private int diaSemana;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String grupo;

	private int hora;

	@Lob
	private String observaciones;

	//uni-directional many-to-one association to AvisoGuardia
	@ManyToOne
	@JoinColumn(name="aviso")
	private AvisoGuardia avisosGuardia;

	//uni-directional many-to-one association to Horario
	@ManyToOne
	@JoinColumn(name="horario")
	private Horario horario;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="prof_falta")
	private Profesor profesor1;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="prof_hace_guardia")
	private Profesor profesor2;

	public Guardia() {
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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getHora() {
		return this.hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public AvisoGuardia getAvisosGuardia() {
		return this.avisosGuardia;
	}

	public void setAvisosGuardia(AvisoGuardia avisosGuardia) {
		this.avisosGuardia = avisosGuardia;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Profesor getProfesor1() {
		return this.profesor1;
	}

	public void setProfesor1(Profesor profesor1) {
		this.profesor1 = profesor1;
	}

	public Profesor getProfesor2() {
		return this.profesor2;
	}

	public void setProfesor2(Profesor profesor2) {
		this.profesor2 = profesor2;
	}

}