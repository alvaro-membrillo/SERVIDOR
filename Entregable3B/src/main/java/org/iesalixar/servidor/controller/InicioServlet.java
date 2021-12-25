package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		DAOUsuarioImpl dao = new DAOUsuarioImpl();
		
		if (usuario != null && password != null) {
			
			Usuario user = dao.getUsuario(usuario);
			
			if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
				
				HttpSession sesion = request.getSession();
				
				sesion.setAttribute("usuario", user.getUsuario());
				sesion.setAttribute("email", user.getEmail());
				sesion.setAttribute("role", user.getRole());
				
				if ("admin".equals(user.getRole())) {
					response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
				} else {
					
					doGet(request, response);
				}
				
			} else {
				request.setAttribute("errorLogin", "Invalid login");
				
				doGet(request, response);
				
				return;
			}
			
		} else {
			
			request.setAttribute("errorLogin", "Invalid login");
			
			doGet(request, response);
			
			return;
			
		}
		
		
	}

}
