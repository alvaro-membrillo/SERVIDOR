package org.iesalixar.servidor.hibernate.dao;

import org.iesalixar.servidor.hibernate.model.Teacher;

public interface TeacherDAO {
	
	public Teacher searchByNSS(final String nss);
}
