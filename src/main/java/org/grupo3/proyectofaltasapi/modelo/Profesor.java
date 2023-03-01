package org.grupo3.proyectofaltasapi.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profesores database table.
 * 
 */
@Entity
@Table(name="profesores")
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte activo;

	private String ape1;

	private String ape2;

	private byte baja;

	@Column(name="dept_cod")
	private String deptCod;

	private String dni;

	@Column(name="id_sustituye")
	private Integer idSustituye;

	private String nombre;

	private String password;

	private String tfno;

	private String user;

	public Profesor() {
	}

	/*
	public Profesor(int id, byte activo, String ape1, String ape2, byte baja, String deptCod, String dni, Integer idSustituye, String nombre, String password, String tfno, String user) {
		this.id = id;
		this.activo = activo;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.baja = baja;
		this.deptCod = deptCod;
		this.dni = dni;
		this.idSustituye = idSustituye;
		this.nombre = nombre;
		this.password = password;
		this.tfno = tfno;
		this.user = user;
	}
	*/

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public byte getBaja() {
		return this.baja;
	}

	public void setBaja(byte baja) {
		this.baja = baja;
	}

	public String getDeptCod() {
		return this.deptCod;
	}

	public void setDeptCod(String deptCod) {
		this.deptCod = deptCod;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getIdSustituye() {
		return this.idSustituye;
	}

	public void setIdSustituye(Integer idSustituye) {
		this.idSustituye = idSustituye;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTfno() {
		return this.tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}