package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLineImpl;

/**
 * Servlet implementation class RemoveProductLineServlet
 */
public class RemoveProductLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//¿PUEDO BORRAR LA CATEGORÍA?
		String productLine = request.getParameter("pl");
		
		
		DAOProductLineImpl dao = new DAOProductLineImpl();
		
		//¿Vale con intentar el borrado en una sola tabla?
		dao.removeProductLine(productLine);
	}

}
