package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOOficina;
import org.iesalixar.servidor.dao.DAOOficinaImpl;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class OficinaServlet
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/oficinas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchTerm = request.getParameter("searchTerm");

		if (searchTerm != null) {

			DAOOficina dao = new DAOOficinaImpl();
			request.setAttribute("oficinas", dao.getOficina(searchTerm));

			doGet(request, response);
			return;
		}

		doGet(request, response);
	}

}
