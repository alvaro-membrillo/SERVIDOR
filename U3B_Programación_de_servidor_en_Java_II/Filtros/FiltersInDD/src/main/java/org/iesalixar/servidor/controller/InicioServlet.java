package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Saco los parámetros a variables para mejorar la legibilidad
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		// Check if the value are not null
		if (usuario != null && password != null) {

			// Comprobamos que los datos de Login son los correctos
			if (("admin".equals(usuario) && "admin".equals(password))
					|| (("usuario".equals(usuario) && "usuario".equals(password)))) {

				// Creo la sesión y la relleno correctamente
				HttpSession sesion = request.getSession();

				sesion.setAttribute("usuario", usuario);

				response.sendRedirect("admin".equals(usuario) ? request.getContextPath() + "/Admin"
						: request.getContextPath() + "/Usuario");
				
				return;

			} 

		}

		// Vuelvo al Login con un GET pero añado un mensaje de error
		request.setAttribute("error", "Datos incorrectos");		
		doGet(request, response);

	}

}
