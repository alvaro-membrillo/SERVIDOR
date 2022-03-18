package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(RegisterServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Client has invoked GET operation [LoginServlet.class]");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
        // si los no campos son nulos
        if (username != null && password != null) {               	
			// si el usuario existe
			if (new UserDAOImpl().getUser(username, password)) {
				// metodo que devuelve un user
				User user = new UserDAOImpl().getAnUser(username, password);
				
				if (BCrypt.checkpw(password, user.getPassword())) {
					
					HttpSession sesion = request.getSession();
					
					sesion.setAttribute("username", user.getUsuario());
					sesion.setAttribute("email", user.getEmail());
					sesion.setAttribute("role", user.getRole());
					
					if ("admin".equals(user.getRole())) {
						
						response.sendRedirect("Admin/Inicio");
						
					} else {
						
						response.sendRedirect("User/Inicio");
						
					}					
					
				} else {
				
					request.setAttribute("error", "Invalid login");
					doGet(request,response);
					return;
				}
				
			} else {
				   
				request.setAttribute("error", "User does not exist");
				doGet(request,response);
				return;
			}			
			
			
		} else {
		
			doGet(request,response);
		
		}		
	}

}
