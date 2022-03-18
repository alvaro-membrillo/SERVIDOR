package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class OfficesServlet
 */
public class OfficesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOOfficeImpl dao = new DAOOfficeImpl();
		ArrayList<Office> oficinas = (ArrayList<Office>) dao.getAllOffices();
		
		request.setAttribute("oficinas", oficinas);
		request.setAttribute("oficinasContexto", oficinas);
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		
	}

}
