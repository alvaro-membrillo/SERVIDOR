package org.iesalixar.servidor.jdperez;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formularios
 */
@WebServlet("/Formularios")
public class Formularios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formularios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String simple = request.getParameter("simple");				 
		
		//Así solo obtengo un valor
		String compuesto = request.getParameter("checkbox");
		
		
		
		out.println("El valor de Simple es: "+simple);
		
		
		String[] valores = request.getParameterValues("checkbox");
		out.println("El valor de Compuesto es: "+Arrays.toString(valores));
		
		String[] seleccion = request.getParameterValues("multiple");
		out.println("El valor de Compuesto es: "+Arrays.toString(seleccion));
		
		
		
	}

}
