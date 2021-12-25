package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Office;

public interface OfficeDAO {
	
	public List<Office> getAllOffices();

	public Office getOffice(String officeCode);
	
	public boolean updateOffice(Office Office, String officeCode);
	
	public boolean deleteOffice(String officeCode);
	
	public boolean addOffice(Office office);
	
	public ArrayList<Office> getOfficeSearch(String searchTerm);
	
}
