package org.iesalixar.servidor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Marca")
public class Marca implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String nombre;
	@Column
	private int year;
	@Column
	private String country;

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	public Marca(int id, String nombre, int year, String country) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.year = year;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
