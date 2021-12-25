package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class CreateProductLineServlet
 */
public class CreateProductLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoria = request.getParameter("productLine");
		String texto = request.getParameter("textDescription");
		String html = request.getParameter("htmlDescription");
		
		
		if (categoria!=null && texto!=null && html!=null) {
			
			DAOProductLineImpl dao = new DAOProductLineImpl();
			
			if (dao.getProductLine(categoria)==null) {
			
				ProductLine pl = new ProductLine(categoria,texto,html);
				
				dao.createProductLine(pl);
				
				response.sendRedirect(request.getContextPath());
			} else {
			
				request.setAttribute("error","Categoría ya existente");
				request.setAttribute("categoria", categoria);
				request.setAttribute("texto", texto);
				request.setAttribute("html", html);
				doGet(request,response);
			}
			
		}
	}

}
