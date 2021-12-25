package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.model.Customer;

/**
 * Servlet implementation class TablaClientesServlet
 */
@WebServlet("/TablaClientesServlet")
public class TablaClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TablaClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo los datos necesarios para pasarlos a la vista
		DAOCustomerImpl daoImpl = new DAOCustomerImpl();
		ArrayList<Customer> customersList = daoImpl.getAllCustomer();		
		
		//Añado la lista de clientes a la petición		
		request.setAttribute("customers",customersList);
		
		//Selecciono la vista
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

}
