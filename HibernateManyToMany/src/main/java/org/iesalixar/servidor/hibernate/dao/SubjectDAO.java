package org.iesalixar.servidor.hibernate.dao;

import org.iesalixar.servidor.hibernate.model.Subject;

public interface SubjectDAO {

	public Subject searchByName(final String name);
}
