package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	final static Logger logger = Logger.getLogger(RegisterServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.getRequestDispatcher("/WEB-INF/view/registerForm.jsp").forward(request, response);
    	
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		
		logger.info("Client has invoked GET operation [RegisterServlet.class]");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");	
		String email = req.getParameter("email");
		
		try {
			
			if(username != null && password != null && email != null) {
			
				User u = new User();
				u.setUsuario(username);
				u.setPassword(password);
				u.setEmail(email);
				
				if(new UserDAOImpl().addUser(u)) {
					
					logger.info("User added successfuly [RegisterServlet.class]");
					resp.sendRedirect("Login");
					
				} else {
					
					logger.info("cannot add the user [RegisterServlet.class]");
					resp.sendRedirect("Register");
					
				}
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}		
	}

}
