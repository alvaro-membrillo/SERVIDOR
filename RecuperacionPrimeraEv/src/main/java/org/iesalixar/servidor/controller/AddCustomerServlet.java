package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddCustomerServlet.class);
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOCustomerImpl dao = new DAOCustomerImpl();
		DAOEmployeeImpl daoEmp = new DAOEmployeeImpl();

		request.setAttribute("customers", dao.getAllCustomers());
		request.setAttribute("listaEmpleados", daoEmp.getAllEmployees());
		
		request.getRequestDispatcher("/WEB-INF/view/admin/addCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String customerName = (String) request.getParameter("customerName");
		String contactLastName = (String) request.getParameter("contactLastName");
		String contactFirstName = (String) request.getParameter("contactFirstName");
		String phone = (String) request.getParameter("phone");
		String addressLine1 = (String) request.getParameter("addressLine1");
		String addressLine2 = (String) request.getParameter("addressLine2");
		String city = (String) request.getParameter("city");
		String state = (String) request.getParameter("state");
		String postalCode = (String) request.getParameter("postalCode");
		String country = (String) request.getParameter("country");
		int salesRepEmployeeNumber = Integer.parseInt(request.getParameter("salesRepEmployeeNumber"));
		int creditLimit = Integer.parseInt(request.getParameter("creditLimit"));

		DAOCustomerImpl dao = new DAOCustomerImpl();
		/*DAOEmployeeImpl daoEmp = new DAOEmployeeImpl();

		Customer customer = new Customer();
		customer = dao.getOffice(customer);

		Employee empleado = new Employee();

		empleado.setEmployeeNumber(employeeNumber);
		empleado.setLastName(lastName);
		empleado.setFirstName(firstName);
		empleado.setExtension(extension);
		empleado.setJobTitle(puesto);
		empleado.setOfficeCode(oficinas.getOfficeCode());
		empleado.setReportsTo(jefe);

		dao.insertEmployee(empleado);

		logger.log(Level.INFO, "Empleado " + empleado.getFirstName() + " añadido");*/

		response.sendRedirect(request.getContextPath() + "/Admin/Empleados");
	}

}
