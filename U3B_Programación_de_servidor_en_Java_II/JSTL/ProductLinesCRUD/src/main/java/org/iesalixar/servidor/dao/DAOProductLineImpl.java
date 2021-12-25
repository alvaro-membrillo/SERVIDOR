package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.ProductLine;

public class DAOProductLineImpl implements DAOProductLine {

	public DAOProductLineImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProductLine getProductLine(String productLine) {

		ProductLine categoria = null;

		try {

			String sql = "select * from productlines where productLine = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine);
			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de productLine
			while (rs.next()) {

				categoria = new ProductLine();

				categoria.setProductLine(rs.getString("productLine"));
				categoria.setTextDescription(rs.getString("textDescription"));
				categoria.setHtmlDescription(rs.getString("htmlDescription"));

			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return categoria;

	}

	@Override
	public ArrayList<ProductLine> getAll() {

		ArrayList<ProductLine> categoriasList = new ArrayList<>();
		ProductLine categoria;

		try {

			String sql = "select * from productlines";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				categoria = new ProductLine();
				categoria.setProductLine(rs.getString("productLine"));
				categoria.setTextDescription(rs.getString("textDescription"));
				categoria.setHtmlDescription(rs.getString("htmlDescription"));

				categoriasList.add(categoria);

			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return categoriasList;

	}

	@Override
	public boolean updateProductLine(ProductLine productLine) {

		int resultado = 0;

		try {

			String sql = "update productlines productLine=?, textDescription=?, htmlDescription=? set  where productLine = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine.getProductLine());
			statement.setString(2, productLine.getTextDescription());
			statement.setString(3, productLine.getHtmlDescription());
			statement.setString(4, productLine.getProductLine());

			resultado = statement.executeUpdate(sql);

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean removeProductLine(String productLine) {

		int resultado = 0;

		try {

			String sql = "delete from productlines where productLine = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine);

			resultado = statement.executeUpdate(sql);

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean createProductLine(ProductLine productLine) {

		int resultado = 0;

		try {

			String sql = "insert into productlines values(?,?,?,null)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine.getProductLine());
			statement.setString(2, productLine.getTextDescription());
			statement.setString(3, productLine.getHtmlDescription());

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);

	}

}
