package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Order;
import org.iesalixar.servidor.model.OrderDetail;

public class DAOOrderImpl implements DAOOrder {

	@Override
	public Order getOrder(int orderNumber) {
		Order order = null;

		try {

			String sql = "select * from orders where  orderNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, orderNumber);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				order = new Order();
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
				
				DAOOrderDetailsImpl daoOD = new DAOOrderDetailsImpl();
				ArrayList<OrderDetail> od = daoOD.getDetailsFromOrder(orderNumber);
				
				order.setOrderDetails(od);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return order;
	}

	@Override
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = new ArrayList<Order>();
		Order order = null;

		try {

			String sql = "select * from orders";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				
				
				order = new Order();
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
				
				DAOOrderDetailsImpl daoOD = new DAOOrderDetailsImpl();
				ArrayList<OrderDetail> od = daoOD.getDetailsFromOrder(order.getOrderNumber());
				
				order.setOrderDetails(od);
				
				orders.add(order);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return orders;
	}

}
