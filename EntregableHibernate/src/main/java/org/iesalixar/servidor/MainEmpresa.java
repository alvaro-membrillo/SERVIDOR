package org.iesalixar.servidor;

import org.hibernate.Session;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.services.UserService;
import org.iesalixar.servidor.services.UserServiceImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class MainEmpresa {

	public static void main(String[] args) {

		// Creo la sesión
		Session session = HibernateUtils.getSessionFactory().openSession();

		// Creo los servicios definidos
		UserService userService = new UserServiceImpl(session);
		
		//Creo los objetos necesarios
		User u1 = new User();
		User u2 = new User();
		
		//Persisto los usuarios
		userService.insertNewUser(u1);
		userService.insertNewUser(u2);
		
		
		//Cerramos la sesión
		session.close();
		
	}

}

