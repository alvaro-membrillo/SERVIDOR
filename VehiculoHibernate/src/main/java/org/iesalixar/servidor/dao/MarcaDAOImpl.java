package org.iesalixar.servidor.dao;

import java.util.List;
import org.hibernate.Session;
import org.iesalixar.servidor.model.Marca;
import org.iesalixar.servidor.model.Vehiculo;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class MarcaDAOImpl extends GenericDAOImpl<Marca> implements MarcaDAO {

	private Session session;

	public MarcaDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Marca searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marca> searchByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marca> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
