package org.iesalixar.servidor.hibernate.onetoone.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.onetoone.model.HistorialMedico;
import org.iesalixar.servidor.hibernate.onetoone.model.Passport;

public class DAOHistorialMedicoImpl implements DAOHistorialMedico {

	private Session session;

	@Override
	public HistorialMedico searchByDni(String dni) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		final List<Passport> historialList = session.createQuery("FROM HistorialMedico WHERE dni =" + dni).list();
		
		HistorialMedico historialMedico = null;
		
		if (historialList != null && historialList.size() > 0) {
			historialMedico = historialList.get(0);
		}
		
		return historialList;
	}

}
