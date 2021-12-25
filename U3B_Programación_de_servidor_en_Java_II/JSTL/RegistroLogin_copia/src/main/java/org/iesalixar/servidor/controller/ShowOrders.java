package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrderImpl;

/**
 * Servlet implementation class ShowOrders
 */
@WebServlet("/ShowOrders")
public class ShowOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOOrderImpl dao = new DAOOrderImpl();
		
		request.setAttribute("pedidos",dao.getAllOrders());
		
		request.getRequestDispatcher("/WEB-INF/view/admin/orders.jsp").forward(request, response);
	}

}
