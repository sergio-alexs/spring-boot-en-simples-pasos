package com.springsimplespasos.universidad.universidadbackend.modelo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({ @JsonSubTypes.Type(value = Alumno.class, name = "alumno"),
		@JsonSubTypes.Type(value = Profesor.class, name = "profesor") })
public abstract class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 60)
	private String nombre;
	@Column(nullable = false, length = 60)
	private String apellido;
	@Column(nullable = false, unique = true, length = 10)
	private String dni;
	@Column(name = "fecha_alta")
	private LocalDateTime fechaAlta;
	@Column(name = "fecha_modificacion")
	private LocalDateTime fechaModificacion;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
			@AttributeOverride(name = "dpto", column = @Column(name = "departamento")) })
	private Direccion direccion;

	public Persona() {
	}

	public Persona(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@PrePersist
	private void antesDePersistir() {
		this.fechaAlta = LocalDateTime.now();
	}

	@PreUpdate
	private void antesDeUpdate() {
		this.fechaModificacion = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Persona{" + "id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni='"
				+ dni + '\'' + ", fechaAlta=" + fechaAlta + ", fechaModificacion=" + fechaModificacion + ", direccion="
				+ direccion + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Persona persona = (Persona) o;
		return id.equals(persona.id) && dni.equals(persona.dni);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, dni);
	}

}
