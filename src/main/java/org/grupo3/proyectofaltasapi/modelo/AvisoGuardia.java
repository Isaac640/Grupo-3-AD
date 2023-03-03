package org.grupo3.proyectofaltasapi.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the avisos_guardia database table.
 * 
 */
@Entity
@Table(name="avisos_guardia")
@NamedQuery(name="AvisoGuardia.findAll", query="SELECT a FROM AvisoGuardia a")
public class AvisoGuardia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_aviso")
	private int idAviso;

	private byte anulado;

	private byte confirmado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_guardia")
	private Date fechaGuardia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora_aviso")
	private Date fechaHoraAviso;

	private String motivo;

	@Lob
	private String observaciones;

	@ManyToOne()
	@JoinColumn(name="horario")
	private Horario horario;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="profesor")
	private Profesor profesor;

	public AvisoGuardia() {
	}

	public int getIdAviso() {
		return this.idAviso;
	}

	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public byte getAnulado() {
		return this.anulado;
	}

	public void setAnulado(byte anulado) {
		this.anulado = anulado;
	}

	public byte getConfirmado() {
		return this.confirmado;
	}

	public void setConfirmado(byte confirmado) {
		this.confirmado = confirmado;
	}

	public Date getFechaGuardia() {
		return this.fechaGuardia;
	}

	public void setFechaGuardia(Date fechaGuardia) {
		this.fechaGuardia = fechaGuardia;
	}

	public Date getFechaHoraAviso() {
		return this.fechaHoraAviso;
	}

	public void setFechaHoraAviso(Date fechaHoraAviso) {
		this.fechaHoraAviso = fechaHoraAviso;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}