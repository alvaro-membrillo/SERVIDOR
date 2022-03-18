package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.database.PoolDB;
import org.iesalixar.servidor.model.Product;

public class ProductDAOImpl implements ProductDAO{
	
	final static Logger logger = Logger.getLogger(ProductDAOImpl.class);	

	@Override
	public Product getProduct(String productName) {
		
		logger.info("getProduct method has been invoked [ProductDAOImpl.class]");
		Product p = new Product();
		boolean exists = false;		
		
		try {
			String sql = "select * from products where productName=?";
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, productName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {					
				
				p.setProductName(rs.getString("productName"));
				p.setProductCode(rs.getString("productCode"));
				p.setProductLine(rs.getString("productLine"));
				p.setProductScale(rs.getString("productScale"));
				p.setProductVendor(rs.getString("productVendor"));
				p.setProductDescription(rs.getString("productDescription"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				p.setBuyPrice(rs.getDouble("buyPrice"));
				p.setMsrp(rs.getDouble("MSRP"));
				
				exists = true;
				
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logger.info("getProduct method has retrieved " + (exists == false ? "with errors " : "successfuly ")
				+ "[ProductDAOImpl.class]");
		return p;
		
	}

	@Override
	public ArrayList<Product> getProductSearch(String searchTerm) {
		
		logger.info("getProductSearch method has been invoked [ProductDAOImpl.class]");	
		
		ArrayList<Product> res = new ArrayList<Product>();
		
		try {
			String sql = "select * from products where  productName LIKE ? OR productLine LIKE ?";	
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, "%" + searchTerm + "%");
			ps.setString(2, "%" + searchTerm + "%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				Product p = new Product();
				
				p.setProductName(rs.getString("productName"));
				p.setProductCode(rs.getString("productCode"));
				p.setProductLine(rs.getString("productLine"));
				p.setProductScale(rs.getString("productScale"));
				p.setProductVendor(rs.getString("productVendor"));
				p.setProductDescription(rs.getString("productDescription"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				p.setBuyPrice(rs.getDouble("buyPrice"));
				p.setMsrp(rs.getDouble("MSRP"));
				
				res.add(p);
				
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logger.info("getProductSearch method has retrieved "+(res.isEmpty()?"nothing":String.valueOf(res.size()))+" [ProductDAOImpl.class]");
		
		return res;
		
	}

	@Override
	public Product getProductByCode(String productCode) {
		
		logger.info("getProductByCode method has been invoked [ProductDAOImpl.class]");
		Product product = null;
		boolean exists = false;
		
		try {

			String sql = "select * from products where productCode = ?";
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, productCode);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {			
				
				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));
				
				exists = true;
				
			}
			
			con.close();
			ps.close();
			

		} catch (SQLException ex) {
			
			System.out.println(ex.getMessage());
			
		} 
		
		logger.info("getProductByCode method has retrieved " + (exists == false ? "with errors " : "successfuly ")
				+ "[ProductDAOImpl.class]");
		return product;
		
	}

	@Override
	public ArrayList<Product> getAllProducts() {

		logger.info("getAllProducts method has been invoked [ProductDAOImpl.class]");	
		
		ArrayList<Product> res = new ArrayList<Product>();
		
		try {
			String sql = "select * from products";	
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				Product p = new Product();
				
				p.setProductName(rs.getString("productName"));
				p.setProductCode(rs.getString("productCode"));
				p.setProductLine(rs.getString("productLine"));
				p.setProductScale(rs.getString("productScale"));
				p.setProductVendor(rs.getString("productVendor"));
				p.setProductDescription(rs.getString("productDescription"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				p.setBuyPrice(rs.getDouble("buyPrice"));
				p.setMsrp(rs.getDouble("MSRP"));
				
				res.add(p);
				
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logger.info("getAllProducts method has retrieved "+(res.isEmpty()?"nothing":String.valueOf(res.size()))+" [ProductDAOImpl.class]");
		
		return res;
		
	}
	
	@Override
	public int getDetailsCountFromProduct(String pCode) {

		logger.info("getDetailsFromProduct method has been invoked [ProductDAOImpl.class]");
		int total = 0;
		
		try {

			String sql = "SELECT COUNT(*) AS total FROM orderdetails WHERE productCode = ?";
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, pCode);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {					
				
				total = rs.getInt("total");				
				
			}
			
			ps.close();
			con.close();

		} catch (SQLException ex) {
			
			System.out.println(ex.getMessage());
			
		} 
		
		

		logger.info("getDetailsFromProduct method has retrieved " + (total == 0 ? "no matches " : + total + " matches")
				+ "[OrderDetailDAOImpl.class]");
		return total;
		
	}
	
	@Override
	public int getSumProductsFromOrder(String pCode) {

		logger.info("getSumProductsFromOrder method has been invoked [ProductDAOImpl.class]");
		int total = 0;
		
		try {

			String sql = "SELECT SUM(quantityOrdered) AS sumaTotal FROM orderdetails WHERE productCode = ?";
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, pCode);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {					
				
				total = rs.getInt("sumaTotal");				
				
			}
			
			ps.close();
			con.close();

		} catch (SQLException ex) {
			
			System.out.println(ex.getMessage());
			
		} 
		
		

		logger.info("getSumProductsFromOrder method has retrieved " + (total == 0 ? "no matches " : + total + " matches")
				+ "[OrderDetailDAOImpl.class]");
		return total;
		
	}

	@Override
	public double getTotalProduct(String pCode) {

		logger.info("getTotalProduct method has been invoked [ProductDAOImpl.class]");
		double total = 0;
		
		try {

			String sql = "SELECT SUM(quantityOrdered*priceEach) AS precioTotal FROM orderdetails WHERE productCode = ?";
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, pCode);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {					
				
				total = rs.getDouble("precioTotal");				
				
			}
			
			ps.close();
			con.close();

		} catch (SQLException ex) {
			
			System.out.println(ex.getMessage());
			
		} 		

		logger.info("getTotalProduct method has retrieved " + (total == 0 ? "no matches " : + total)
				+ "[OrderDetailDAOImpl.class]");
		return total;
		
	}

	@Override
	public boolean updateProduct(Product p, String productCode) {

		logger.info("updateProduct method has been invoked [ProductDAOImpl.class]");
		int status = 0; 		
		
		try {
			String sql = "UPDATE products SET productName = ?, productLine = ?, productScale = ?, productVendor = ?, productDescription = ? , quantityInStock = ?, buyPrice = ?, MSRP = ?  WHERE productCode = ?";
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);			
			ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductLine());    				
			ps.setString(3, p.getProductScale());
			ps.setString(4, p.getProductVendor());
			ps.setString(5, p.getProductDescription());
			ps.setInt(6, p.getQuantityInStock());
			ps.setDouble(7, p.getBuyPrice());
			ps.setDouble(8, p.getMsrp());
			ps.setString(9, productCode);
			
			status = ps.executeUpdate(); 
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}       
        
        logger.info("updateProduct method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[ProductDAOImpl.class]");
        return (status == 0 ?false:true); 
		
	}

}
