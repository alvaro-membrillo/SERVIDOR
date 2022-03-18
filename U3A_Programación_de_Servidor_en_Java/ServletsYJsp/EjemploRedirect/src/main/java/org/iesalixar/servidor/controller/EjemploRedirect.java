package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.model.Usuario;

/**
 * Servlet implementation class EjemploRedirect
 */
public class EjemploRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("destino")!=null) {
			
			if (request.getParameter("destino").equalsIgnoreCase("A")) {
				
				Usuario usuario = new Usuario();
				usuario.setUsuario("admin");
				usuario.setPassword("admin");
				request.setAttribute("usuario", usuario);
				
				request.getRequestDispatcher("a.jsp").forward(request, response);
				
			} else {
				Usuario usuario = new Usuario();
				usuario.setUsuario("pepe");
				usuario.setPassword("pepe");
				request.setAttribute("usuario", usuario);
				
				request.getRequestDispatcher("b.jsp").forward(request, response);
				
			}
		} else {
			PrintWriter out = response.getWriter();
			
			out.println("NO SE ADONDE IR");
		}
	}

}
