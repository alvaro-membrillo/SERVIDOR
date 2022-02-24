package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AddProductServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* DAOOfficesImpl dao = new DAOOfficesImpl(); */
		DAOProductImpl dao = new DAOProductImpl();

		request.setAttribute("productos", dao.getAllProducts());

		request.getRequestDispatcher("../WEB-INF/view/admin/addProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCode = request.getParameter("productCode");
		String productName = (String) request.getParameter("productName");
		String productLine = (String) request.getParameter("productLine");
		String productScale = (String) request.getParameter("productScale");
		String productVendor = (String) request.getParameter("productVendor");
		String productDescription = (String) request.getParameter("productDescription");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double buyPrice = (double) Integer.parseInt(request.getParameter("buyPrice"));
		double msrp = (double) Integer.parseInt(request.getParameter("msrp"));

		DAOProductImpl dao = new DAOProductImpl();
		DAOProductLineImpl daoPl = new DAOProductLineImpl();
		//DAOOfficesImpl daoOf = new DAOOfficesImpl(); */

		/*
		 * Offices oficinas = new Offices(); oficinas = daoOf.getOffice(oficina);
		 */
		
		List<ProductLine> objetoProductLine = new ProductLine();
		objetoProductLine = daoPl.getAllProductLines();
		
		

		Product producto = new Product();

		producto.setProductCode(productCode);
		producto.setProductName(productName);
		producto.setProductLine(objetoProductLine);
		producto.setProductScale(productScale);
		producto.setProductVendor(productVendor);
		producto.setProductDescription(productDescription);
		producto.setQuantityInStock(stock);
		producto.setBuyPrice(buyPrice);
		producto.setMsrp(msrp);
		
		dao.insertProduct(producto);

		logger.log(Level.INFO, "producto " + producto.getProductName() + " añadido");

		response.sendRedirect(request.getContextPath() + "/Home");
	}

}
