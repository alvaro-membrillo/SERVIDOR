package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOffice;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class Oficinas
 */

public class OficinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Obtengo la lsita de oficinas usando el DAO
		DAOOffice dao = new DAOOfficeImpl();		
		List<Office> oficinas = dao.getAllOffices();
		List<Office> oficinasContexto = dao.getAllOfficesContext();
		
		request.setAttribute("oficinas", oficinas);
		request.setAttribute("oficinasContexto", oficinasContexto);
		
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		
		
	}

	

}
