package org.iesalixar.servidor.dto;

import java.util.ArrayList;
import java.util.List;

public class EntradaDTO {
	
	private List<String> grupos;
	private int numEntradas;
	private String categoria;
	
	public EntradaDTO() {
		grupos = new ArrayList<>();
	}

	public List<String> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<String> grupos) {
		this.grupos = grupos;
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
