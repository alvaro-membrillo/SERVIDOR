package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;

public class DAOProductLineImpl implements DAOProductLine {

	@Override
	public List<ProductLine> getAllProductLines() {
		
		ArrayList<ProductLine> productLines = new ArrayList<>();
		Connection con = null;

		try {

			String sql = "select * from productlines";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ProductLine productLine = new ProductLine();

				productLine.setProductLine(rs.getString("productCode"));
				productLine.setTextDescription(rs.getString("productName"));
				//productLine.setHtmlDescription(rs.getString("productLine"));
				
				productLines.add(productLine);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return productLines;
		
	}

	@Override
	public ProductLine getProductLine(String productLine) {
		ProductLine objProductLine = null;
		Connection con = null;
		
		try {
			
			String sql = "select * from productlines where productLine=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, productLine);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {

				objProductLine = new ProductLine();

				objProductLine.setProductLine(rs.getString("productLine"));
				objProductLine.setTextDescription(rs.getString("textDescription"));
				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}

		return objProductLine;

	}

}
