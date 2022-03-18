package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.model.Maquinista;
import org.iesalixar.servidor.model.Tren;
import org.iesalixar.servidor.model.Vagon;

/**
 * Servlet implementation class TrenServlet
 */
@WebServlet("/TrenServlet")
public class TrenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TrenServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Maquinista maquinista = new Maquinista("Pepe","Perez","22222222X");
		ArrayList<Vagon> vagones = new ArrayList<>();
		Vagon v1 = new Vagon(1000,1600);
		Vagon v2 = new Vagon(2000,1700);
		Vagon v3 = new Vagon(3000,1800);
		Vagon v4 = new Vagon(4000,1900);
		Vagon v5 = new Vagon(5000,1500);
		
		vagones.add(v1);
		vagones.add(v2);
		vagones.add(v3);
		vagones.add(v4);
		vagones.add(v5);
		
		Tren tren = new Tren("AVE",maquinista,vagones);
		
		request.setAttribute("tren", tren);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	

}
