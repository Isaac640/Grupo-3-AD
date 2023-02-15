package org.grupo3.proyectofaltasapi.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profesor_tiene_perfil database table.
 * 
 */
@Entity
@Table(name="profesor_tiene_perfil")
@NamedQuery(name="ProfesorTienePerfil.findAll", query="SELECT p FROM ProfesorTienePerfil p")
public class ProfesorTienePerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="perfil")
	private Perfil perfil;

	//uni-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="profesor")
	private Profesor profesor;

	public ProfesorTienePerfil() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}