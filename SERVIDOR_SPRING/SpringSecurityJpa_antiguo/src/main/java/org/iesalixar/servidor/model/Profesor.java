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

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 9, nullable = true)
	private String nif;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido1;

	@Column(nullable = true)
	private String apellido2;

	@Column
	private String ciudad;

	@Column
	private String direccion;

	@Column(nullable = true)
	private String telefono;

	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(nullable = false, length = 1)
	private String sexo;

	/*@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Profesor> profesores = new HashSet<>();*/
	
	@ManyToOne
	@JoinColumn(name="id_departamento")
	Departamento departamento;

	public Profesor() {
		// TODO Auto-generated constructor stub
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/*public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}*/

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, ciudad, departamento, direccion, fechaNacimiento, id, nif, nombre,
				/*profesores,*/ sexo, telefono);
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
				&& Objects.equals(ciudad, other.ciudad) && Objects.equals(departamento, other.departamento)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(id, other.id) && Objects.equals(nif, other.nif)
				&& Objects.equals(nombre, other.nombre)
				&& /*Objects.equals(profesores, other.profesores) &&*/ Objects.equals(sexo, other.sexo)
				&& Objects.equals(telefono, other.telefono);
	}

}
