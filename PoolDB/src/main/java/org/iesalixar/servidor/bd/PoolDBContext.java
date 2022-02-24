package org.iesalixar.servidor.bd;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class PoolDBContext {
	
	public DataSource dataSource;
	

	public PoolDBContext() {
		initDataSource();		
	}
	
	private void initDataSource() {

		Context initContext;		
		
		try {
			initContext = new InitialContext();
			
			dataSource = (BasicDataSource) initContext.lookup("java:/comp/env/jdbc/ConexionMariadb");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
