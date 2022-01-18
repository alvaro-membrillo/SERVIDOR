package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Offices;

public interface DAOOffices {

	public ArrayList<Offices> getAllOficinas();
	public Offices getOffice(String officeCode);
	
}
