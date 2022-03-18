package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(MainServlet.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//Destruyo la sesión
		request.getSession().invalidate();
		
		//Logeo que he salido de sesión
		logger.info("El usuario ha salido de sesión");
		
		//Vuelvo a la página principal de la aplicación
		//Deberá estar mapeado correctamente el Servlet en el web.xml
		response.sendRedirect(request.getContextPath());
	}

}
