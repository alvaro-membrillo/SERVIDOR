package org.iesalixar.servidor.hibernate.onetoone.dao;

import org.iesalixar.servidor.hibernate.onetoone.model.HistorialMedico;

public interface DAOHistorialMedico {
	
	public HistorialMedico searchByDni(final String dni);
	
}
