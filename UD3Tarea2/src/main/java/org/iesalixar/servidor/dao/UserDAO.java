package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.User;

public interface UserDAO {
	
	public List<User> getAllUsers();
	
	public boolean getUser(String username, String password);
	
	public boolean addUser(User user);

}
