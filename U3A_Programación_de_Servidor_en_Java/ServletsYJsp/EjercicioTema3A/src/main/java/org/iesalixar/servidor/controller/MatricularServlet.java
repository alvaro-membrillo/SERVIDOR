package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class MatricularServlet
 */
@WebServlet("/MatricularServlet")
public class MatricularServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(MatricularServlet.class);


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatricularServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtenemos la sesión
		HttpSession sesion = request.getSession();

		// Compruebo si existe sesión
		if (!sesion.isNew() && sesion.getAttribute("LOGEADO") != null && ((boolean) sesion.getAttribute("LOGEADO"))) {
			
			
			//Obtengo el valor de la Cookie que me interesa (curso)
			Cookie[] cookies = request.getCookies();
			
			//Recorro las cookies hasta obtener la que estoy buscando
			for (Cookie c:cookies) {
				
				if (c.getName().equals("curso")) {
					request.setAttribute("curso", c.getValue().equals("primero") ? "1º DAW" : "2º DAW");
				}
			}
			request.getRequestDispatcher("matricular.jsp").forward(request, response);			
			return;
		}
		
		//Logeo que ha intentado entrar directamente en la aplicación sin tener sesión
		logger.error("Intento de entrar en Matricular sin tener sesión");
		
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
		
		
	}

}
