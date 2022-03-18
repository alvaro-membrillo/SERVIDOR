package org.iesalixar.servidor.services;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.MarcaDAO;
import org.iesalixar.servidor.dao.MarcaDAOImpl;
import org.iesalixar.servidor.model.Marca;

public class MarcaServiceImpl implements MarcaService {
	
	private MarcaDAO marcaDAO;
	
	public MarcaServiceImpl(final Session session) {
		this.marcaDAO = new MarcaDAOImpl(session);
	}
	
	public Marca searchByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	public Marca searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
