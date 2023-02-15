package org.grupo3.proyectofaltasapi.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the horariocentro database table.
 * 
 */
@Entity
@Table(name = "horariocentro")
@NamedQuery(name="HorarioCentro.findAll", query="SELECT h FROM HorarioCentro h")
public class HorarioCentro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Time horafin;

	private Time horainicio;

	private String turno;

	public HorarioCentro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Time horafin) {
		this.horafin = horafin;
	}

	public Time getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}