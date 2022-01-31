package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Marca;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface MarcaDAO extends GenericDAO<Marca> {
	
	public List<Marca> searchByCountry(final String country);
	public List<Marca> searchByName (final String name);

}
