package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.model.Customer;

/**
 * Servlet implementation class ClienteInfoServlet
 */
@WebServlet("/ClienteInfoServlet")
public class ClienteInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo el identificador del cliente del GET
		int customerId = Integer.parseInt((String)request.getParameter("customerId"));
		
		//Obtengo los datos de ese cliente en concreto a través del DAO
		DAOCustomerImpl customerDAOImpl = new DAOCustomerImpl();		
		Customer customer = customerDAOImpl.getCustomer(customerId);
		
		//Añado esa información a la vista para ser mostrada
		request.setAttribute("customer", customer);
		
		request.getRequestDispatcher("WEB-INF/view/customer.jsp").forward(request, response);;
		
	}

}
