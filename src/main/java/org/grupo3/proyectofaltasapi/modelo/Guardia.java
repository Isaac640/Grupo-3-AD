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
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="aviso")
	private AvisoGuardia avisosGuardia;

	//uni-directional many-to-one association to Horario
	@ManyToOne
	@JoinColumn(name="horario")
	private Horario horario;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="prof_falta")
	private Profesor profFalta;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="prof_hace_guardia")
	private Profesor profGuardia;

	public Guardia() {
	}
	
	public Guardia(AvisoGuardia aviso) {
		profFalta = aviso.getProfesor();
		estado = "C";
		fecha = aviso.getFechaGuardia();
		horario = aviso.getHorario();
		diaSemana = aviso.getHorario().getDiaSemana();
		hora = 1;
		avisosGuardia = aviso;
		grupo = aviso.getHorario().getGrupo();
		aula = aviso.getHorario().getAula();
		observaciones = aviso.getObservaciones();
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

	public Profesor getProfFalta() {
		return this.profFalta;
	}

	public void setProfFalta(Profesor profFalta) {
		this.profFalta = profFalta;
	}

	public Profesor getProfGuardia() {
		return this.profGuardia;
	}

	public void setProfGuardia(Profesor profGuardia) {
		this.profGuardia = profGuardia;
	}

}