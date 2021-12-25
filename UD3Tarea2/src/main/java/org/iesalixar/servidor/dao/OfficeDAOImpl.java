package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.database.PoolDB;
import org.iesalixar.servidor.model.Office;

public class OfficeDAOImpl implements OfficeDAO{
	
	final static Logger logger = Logger.getLogger(OfficeDAOImpl.class);
	
	@Override
	public List<Office> getAllOffices() {

		logger.info("getAllOffices method has been invoked [OfficeDAOImpl.class]");
		
		List<Office> res = new ArrayList<Office>();			
		
		try {
			
			String sql = "select * from offices";	
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				try {

					Office f = new Office();
					
					f.setOfficeCode(rs.getString(1));
					f.setCity(rs.getString(2));
					f.setPhone(rs.getString(3));
					f.setAddressLine1(rs.getString(4));
					f.setAddressLine2(rs.getString(5));
					f.setState(rs.getString(6));
					f.setCountry(rs.getString(7));
					f.setPostalCode(rs.getString(8));
					f.setTerritory(rs.getString(9));
					
					res.add(f);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logger.info("getAllOffices method has retrieved "+(res.isEmpty()?"nothing":String.valueOf(res.size()))+" [OfficeDAOImpl.class]");
		
		return res;
		
	}

	@Override
	public Office getOffice(String officeCode) {

		Office f = new Office();
		logger.info("getOffice method has been invoked [OfficeDAOImpl.class]");
		
		try {
			String sql = "SELECT * FROM `offices` WHERE city = ?";
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, officeCode);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				f.setOfficeCode(rs.getString(1));
				f.setCity(rs.getString(2));
				f.setPhone(rs.getString(3));
				f.setAddressLine1(rs.getString(4));
				f.setAddressLine2(rs.getString(5));
				f.setState(rs.getString(6));
				f.setCountry(rs.getString(7));
				f.setPostalCode(rs.getString(8));
				f.setTerritory(rs.getString(9));

			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logger.info("getOffice method has retrieved [OfficeDAOImpl.class]");
		return f;
		
	}

	@Override
	public boolean updateOffice(Office o, String officeCode) {
		
		logger.info("updateOffice method has been invoked [OfficeDAOImpl.class]"); 
		int status = 0; 
		
		try {
			String sql = "UPDATE offices SET officeCode = ?, city = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, state = ?, country = ?, postalCode = ?, territory = ? WHERE officeCode = ?";

			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, o.getOfficeCode());
			ps.setString(2, o.getCity());    				
			ps.setString(3, o.getPhone());
			ps.setString(4, o.getAddressLine1());
			ps.setString(5, o.getAddressLine2());
			ps.setString(6, o.getState());
			ps.setString(7, o.getCountry());
			ps.setString(8, o.getPostalCode());
			ps.setString(9, o.getTerritory());
			ps.setString(10, officeCode);
			
			status = ps.executeUpdate(); 
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
 
        logger.info("updateOffice method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[OfficeDAOImpl.class]");
        return (status == 0 ?false:true); 
		
	}

	@Override
	public boolean deleteOffice(String officeCode) {
		
		logger.info("deleteOffice method has been invoked [OfficeDAOImpl.class]"); 
		int status = 0; 
		
		try {
			String sql = "DELETE FROM offices WHERE officeCode = ?";
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setString(1, officeCode);
			
			status = ps.executeUpdate(); 
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
         
        logger.info("deleteOffice method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[OfficeDAOImpl.class]");
        return (status == 0 ?false:true);  
		
	}

	@Override
	public boolean addOffice(Office o) {
		logger.info("addOffice method has been invoked [OfficeDAOImpl.class]");
		int status = 0;

		try {
			// si es nulo quiero decir que el Office no existe, por lo tanto podemos crearlo
			if (getOffice(o.getOfficeCode()) == null) {

				String sql = "insert into offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PoolDB pool = new PoolDB();				
				Connection con = pool.getConnection();
				
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);						
				
				ps.setString(1, o.getOfficeCode());
				ps.setString(2, o.getCity());    				
				ps.setString(3, o.getPhone());
				ps.setString(4, o.getAddressLine1());
				ps.setString(5, o.getAddressLine2());
				ps.setString(6, o.getState());
				ps.setString(7, o.getCountry());
				ps.setString(8, o.getPostalCode());
				ps.setString(9, o.getTerritory());

				status = ps.executeUpdate();
				
				ps.close();
				con.close();

			} else {

				logger.info("The product line already exists [ProductLineDAOImpl.class]");

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		logger.info("addOffice method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[OfficeDAOImpl.class]");
		return (status == 0 ? false : true);
		
	}
	
	@Override
	public ArrayList<Office> getOfficeSearch(String searchTerm) {
		
		logger.info("getOfficeSearch method has been invoked [OfficeDAOImpl.class]");	
		
		ArrayList<Office> res = new ArrayList<Office>();
		
		try {
			String sql = "select * from offices where city LIKE ?";	
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);	
			ps.setString(1, "%" + searchTerm + "%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				try {
					
					Office o = new Office();						
					
					o.setOfficeCode(rs.getString("officeCode"));
					o.setCity(rs.getString("city"));
					o.setPhone(rs.getString("phone"));
					o.setAddressLine1(rs.getString("addressLine1"));
					o.setAddressLine2(rs.getString("addressLine2"));
					o.setState(rs.getString("state"));
					o.setCountry(rs.getString("country"));
					o.setPostalCode(rs.getString("postalCode"));
					o.setTerritory(rs.getString("territory"));
					
					res.add(o);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logger.info("getOfficeSearch method has retrieved "+(res.isEmpty()?"nothing":String.valueOf(res.size()))+" [OfficeDAOImpl.class]");
		
		return res;
		
	}

}
