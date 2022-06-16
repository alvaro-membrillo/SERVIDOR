package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nif", unique = true, nullable = false)
	private String nif;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellido1", nullable = false)
	private String apellido1;

	@Column(name = "apellido2", nullable = false)
	private String apellido2;

	@Column(name = "ciudad", nullable = false)
	private String ciudad;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	@Column(name = "telefono", nullable = false)
	private String telefono;

	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fecha_nacimiento;

	@Column(name = "sexo", nullable = false)
	private String sexo;

	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Asignatura> asignaturas = new HashSet<>();

	@Column(name = "id_departamento", nullable = false)
	private int departamento;

	public Profesor() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFullName() {

		return this.nombre + "," + this.apellido1 + " " + this.apellido2;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, asignaturas, ciudad, direccion, fecha_nacimiento, id, departamento,
				nif, nombre, sexo, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(asignaturas, other.asignaturas) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(direccion, other.direccion)
				&& Objects.equals(fecha_nacimiento, other.fecha_nacimiento) && Objects.equals(id, other.id)
				&& departamento == other.departamento && Objects.equals(nif, other.nif)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sexo, other.sexo)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", ciudad=" + ciudad + ", direccion=" + direccion + ", telefono="
				+ telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", sexo=" + sexo + ", asignaturas="
				+ asignaturas + ", departamento=" + departamento + "]";
	}

}
