package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.database.PoolDB;
import org.iesalixar.servidor.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAOImpl implements UserDAO{
	
	final static Logger logger = Logger.getLogger(UserDAOImpl.class);	
	
	public List<User> getAllUsers() {
		
		logger.info("getAllUsers method has been invoked [UserDAOImpl.class]");
		
		List<User> res = new ArrayList<User>();
		PoolDB pool = new PoolDB();				
		Connection con = pool.getConnection();
		PreparedStatement ps;
		if(con != null) {
			
			String sql = "select * from users";			
			
			try {
				ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					try {
						
						User u = new User();
						
						u.setUsuario(rs.getString(1));						
						u.setEmail(rs.getString(2));
						u.setPassword(rs.getString(3));
						
						res.add(u);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		logger.info("getAllUsers method has retrieved "+(res.isEmpty()?"nothing":String.valueOf(res.size()))+" [UserDAOImpl.class]");
		
		return res;
	}

	public boolean getUser(String username, String password) {
		
		boolean exists = false;
		logger.info("getUser method has been invoked [UserDAOImpl.class]");
		
		PoolDB pool = new PoolDB();				
		Connection con = pool.getConnection();
		PreparedStatement ps;
		if(con != null) {

			String sql = "SELECT * FROM `usuarios` WHERE usuario = ?";
			
			try {
				ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					// obtenemos el valor del atributo 'password' procedente de la query realizada
					String hashedPassword = rs.getString("password");
					
					try {
						// si la contraseña en texto plano coincide con la contraseña ya hasheada
						if(BCrypt.checkpw(password, hashedPassword)) {
							exists = true;
						}						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		logger.info("getUser method has retrieved " + (exists == false ? "with errors " : "successfuly ")
				+ "[UserDAOImpl.class]");
		return exists;
		
	}
	
	public User getAnUser(String username, String password) {
		
		User u = new User();
		boolean exists = false;
		logger.info("getAnUser method has been invoked [UserDAOImpl.class]");
		
		PoolDB pool = new PoolDB();				
		Connection con = pool.getConnection();
		PreparedStatement ps;
		if(con != null) {

			String sql = "SELECT * FROM `usuarios` WHERE usuario = ?";
			
			try {
				ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					// obtenemos el valor del atributo 'password' procedente de la query realizada
					String hashedPassword = rs.getString("password");
					try {
						// si la contraseña en texto plano coincide con la contraseña ya hasheada
						if(BCrypt.checkpw(password, hashedPassword)) {
							
							u.setUsuario(rs.getString("usuario"));
							u.setEmail(rs.getString("email"));
							u.setPassword(rs.getString("password"));
							u.setRole(rs.getString("role"));
							
							exists = true;
						}						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		logger.info("getAnUser method has retrieved " + (exists == false ? "with errors " : "successfuly ")
				+ "[UserDAOImpl.class]");
		return u;
		
	}

	@Override
	public boolean addUser(User u) {
		int status = 0;
		
		logger.info("addUser method has been invoked [UserDAOImpl.class]");
		
		PoolDB pool = new PoolDB();				
		Connection con = pool.getConnection();
		PreparedStatement ps;
		if(con != null) {

			String sql = "INSERT INTO USUARIOS VALUES(?, ?, ?, ?)";
			
			try {
				// metodo hashpw que recibe una texto_plano y un salt(log)
				String passHashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt(10));
				ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, u.getUsuario());								
				ps.setString(2, u.getEmail());
				// introducimos la contraseña hasheada
				ps.setString(3, passHashed);				
				ps.setString(4, "usuario");
				
				
				status = ps.executeUpdate();
				
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		logger.info("addUser method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[UserDAOImpl.class]");
		return (status == 0 ? false : true);
		
	}

}
