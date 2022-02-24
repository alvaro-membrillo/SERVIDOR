package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Order;

public class DAOOrderImpl implements DAOOrder {

	@Override
	public List<Order> getAllOrders() {

		ArrayList<Order> listaPedidos = new ArrayList<>();
		Order pedido = null;
		Connection con = null;
		try {
			String sql = "select * from orders";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				pedido = new Order();
				pedido.setOrderNumber(rs.getInt("orderNumber"));
				pedido.setOrderDate(rs.getString("orderDate"));
				pedido.setRequiredDate(rs.getString("requiredDate"));
				pedido.setShippedDate(rs.getString("shippedDate"));
				pedido.setStatus(rs.getString("status"));
				pedido.setComments(rs.getString("comments"));
				pedido.setCustomerNumber(rs.getInt("customerNumber"));
				
				listaPedidos.add(pedido);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listaPedidos;
	}

}
