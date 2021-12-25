package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.ProductLine;


/**
 * Servlet implementation class ProductLinesServlet
 */
public class ProductLinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductLinesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo desde la base de datos y través del DAO todos los productlines
		DAOProductLineImpl dao = new DAOProductLineImpl();
		ArrayList<ProductLine> categorias = dao.getAll();
		
		
		request.setAttribute("categorias", categorias);
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}
