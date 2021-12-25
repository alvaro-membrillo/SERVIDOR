package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.database.PoolDB;
import org.iesalixar.servidor.model.ProductLine;

public class ProductLineDAOImpl implements ProductLineDAO {

	final static Logger logger = Logger.getLogger(ProductLineDAOImpl.class);

	@Override
	public List<ProductLine> getAllProductLines() {

		logger.info("getAllProductLines method has been invoked [ProductLineDAOImpl.class]");

		List<ProductLine> res = new ArrayList<ProductLine>();

		try {
			String sql = "select * from productlines";
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				try {

					ProductLine p = new ProductLine();

					p.setProductLine(rs.getString(1));
					p.setTextDescription(rs.getString(2));
					p.setHtmlDescription(rs.getString(3));

					res.add(p);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.info("getAllProductLines method has retrieved "
				+ (res.isEmpty() ? "nothing" : String.valueOf(res.size())) + " [ProductLineDAOImpl.class]");

		return res;

	}

	@Override
	public ProductLine getProductLine(String productLine) {

		ProductLine p = null;
		logger.info("getProductLine method has been invoked [ProductLineDAOImpl.class]");

		try {
			String sql = "SELECT * FROM `productlines` WHERE productLine = ?";

			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, productLine);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				p = new ProductLine();

				p.setProductLine(rs.getString(1));
				p.setTextDescription(rs.getString(2));
				p.setHtmlDescription(rs.getString(3));

			}

			ps.close();
			con.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		logger.info("getProductLine method has retrieved " + p + " [ProductLineDAOImpl.class]");
		return p;
	}

	@Override
	public boolean updateProductLine(ProductLine p) {
		logger.info("updateProductLine method has been invoked [ProductLineDAOImpl.class]");
		int status = 0;

		try {
			String sql = "UPDATE productLines SET htmlDescription = ?, textDescription = ? WHERE productLine = ?";
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, p.getTextDescription());
			ps.setString(2, p.getHtmlDescription());
			ps.setString(3, p.getProductLine());

			status = ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.info("updateProductLine method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[ProductLineDAOImpl.class]");
		return (status == 0 ? false : true);

	}

	@Override
	public boolean deleteProductLine(String productLine) {
		logger.info("deleteProductLine method has been invoked [ProductLineDAOImpl.class]");
		int status = 0;

		try {
			String sql = "DELETE FROM productLines WHERE productLine = ?";
			
			PoolDB pool = new PoolDB();				
			Connection con = pool.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, productLine);

			status = ps.executeUpdate();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.info("deleteProductLine method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[ProductLineDAOImpl.class]");
		return (status == 0 ? false : true);
	}

	@Override
	public boolean addProductLine(ProductLine p) {
		logger.info("addProductLine method has been invoked [ProductLineDAOImpl.class]");
		int status = 0;

		try {
			// si es nulo quiero decir que el productLine no existe, por lo tanto podemos crearlo
			if (getProductLine(p.getProductLine()) == null) {
				String sql = "insert into productlines(productLine, textDescription, htmlDescription) VALUES(?, ?, ?)";
				
				PoolDB pool = new PoolDB();				
				Connection con = pool.getConnection();
				
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, p.getProductLine());
				ps.setString(2, p.getTextDescription());
				ps.setString(3, p.getHtmlDescription());

				status = ps.executeUpdate();
				
				ps.close();
				con.close();

			} else {

				logger.info("The product line already exists [ProductLineDAOImpl.class]");

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		logger.info("addProductLine method has retrieved " + (status == 0 ? "with errors " : "successfuly ")
				+ "[ProductLineDAOImpl.class]");
		return (status == 0 ? false : true);

	}

}
