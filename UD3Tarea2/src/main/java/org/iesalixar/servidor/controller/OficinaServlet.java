package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.OfficeDAOImpl;

@WebServlet(name = "OficinaServlet", urlPatterns = { "/User/Oficinas" })
public class OficinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setAttribute("officeList", new OfficeDAOImpl().getAllOffices());
    	
    	if(request.getParameter("busqueda") != null) {
    		
    		String searchTerm = request.getParameter("busqueda");
    		
    		request.setAttribute("office", new OfficeDAOImpl().getOffice(searchTerm));
    		
    	}
    	
    	request.getRequestDispatcher("/WEB-INF/view/user/searchOffice.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchTerm = request.getParameter("busqueda");
		
		if(searchTerm != null) {
			
			request.setAttribute("office", new OfficeDAOImpl().getOffice(searchTerm));
			
			doGet(request, response);
			
		}	
		
		
	}


}
