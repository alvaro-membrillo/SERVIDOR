package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(MainServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Redirigo al jsp que mostrará distintos elementos dependiendo de si hay sesión o no
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Compruebo que efectivamente vengo de pulsar el botón ENTRAR
		if (request.getParameter("entrar")!=null && request.getParameter("entrar").equals("ENTRAR")) {
			
			//Creo la sesión y le voy a añadir una variable booleana para realizar la comprobaciones posteriores
			HttpSession sesion = request.getSession();
			
			//Logeo que he entrado en sesión
			logger.info("El usuario ha entrado en sesión");
			
			sesion.setAttribute("LOGEADO", true);
			
			//Redirijo el flujo de la aplicación al formulario de matriculación
			response.sendRedirect(request.getContextPath()+"/SeleccionServlet");
			
			return;
		}
		
		//No vengo de presionar al botón entrar y he recibido un POST. Vuelvo al GET de este mismo Servlet
		response.sendRedirect(request.getContextPath());
		
		
	}

}
