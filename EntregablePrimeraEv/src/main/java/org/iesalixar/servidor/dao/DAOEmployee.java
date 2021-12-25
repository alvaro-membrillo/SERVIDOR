package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import org.iesalixar.servidor.model.Employee;

public interface DAOEmployee {
	
	//Para mostrar todos los empleados*/
	public ArrayList<Employee> getAllEmployees();
	//Buscador de empleados*/
	public ArrayList<Employee> getEmployeeSearch(String searchTerm);
	//Read
	public Employee getEmployee(String firstName);
	//Remove
	public boolean removeEmployee(int employeeNumber);
	//Update
	public boolean updateEmployee(Employee employee);
	//Add
	public boolean insertEmployee(Employee employee);
	
	
}
