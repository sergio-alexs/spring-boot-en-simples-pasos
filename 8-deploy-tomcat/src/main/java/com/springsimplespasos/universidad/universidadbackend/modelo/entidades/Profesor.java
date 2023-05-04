package com.springsimplespasos.universidad.universidadbackend.modelo.entidades;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona {

	private static final long serialVersionUID = 1L;

	private BigDecimal sueldo;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "profesor_carrera", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	private Set<Carrera> carreras;

	public Profesor() {
	}

	public Profesor(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo) {
		super(id, nombre, apellido, dni, direccion);
		this.sueldo = sueldo;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(Set<Carrera> carreras) {
		this.carreras = carreras;
	}

	@Override
	public String toString() {
		return super.toString() + "\tProfesor{" + "sueldo=" + sueldo + '}';
	}
}
