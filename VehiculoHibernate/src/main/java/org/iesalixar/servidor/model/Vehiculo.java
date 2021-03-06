package org.iesalixar.servidor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehiculo")
public class Vehiculo implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String matricula;
	@Column
	private String color;
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(int id, String matricula, String color) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
