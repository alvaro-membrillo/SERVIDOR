package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOPaymentImpl;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Payment;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class ViewProductServlet
 */
@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String productCode = request.getParameter("view");
		
		if (productCode != null) {

			DAOProductImpl daoProductImpl = new DAOProductImpl();

			Product product = daoProductImpl.getProduct(productCode);
			
			request.setAttribute("productos", product);

			request.getRequestDispatcher("/WEB-INF/view/viewProduct.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("/WEB-INF/view/searchProduct.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
