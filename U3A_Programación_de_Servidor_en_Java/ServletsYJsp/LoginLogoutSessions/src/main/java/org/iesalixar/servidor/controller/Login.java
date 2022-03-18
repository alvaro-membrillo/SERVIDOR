package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.model.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		HttpSession sesion = null;
		
		
		
		if (usuario.equals("admin") && password.equals("admin")) {
			
			sesion = request.getSession();
			Usuario user = new Usuario();
			user.setNombre(usuario);
			sesion.setAttribute("usuario",user );
			
			response.sendRedirect("AdminServlet");
			
		} else if (usuario.equals("normal") && password.equals("normal")) {
			
			sesion = request.getSession();
			Usuario user = new Usuario();
			user.setNombre(usuario);
			sesion.setAttribute("usuario",user );
			
			response.sendRedirect("UsuarioServlet");
			
		} else {
			response.sendRedirect("Login");
		}
	}

}
