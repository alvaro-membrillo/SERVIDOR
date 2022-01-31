package org.iesalixar.servidor.services;

import org.iesalixar.servidor.model.Marca;

public interface MarcaService {
	
	public Marca searchByCountry(String country);
	public Marca searchByName(String name);
	
}
