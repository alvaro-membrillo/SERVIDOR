package org.iesalixar.servidor.services;

import org.iesalixar.servidor.model.Vehiculo;

public interface VehiculoService {
	
	public void insertNewVehiculo (final Vehiculo empleado);	
	 
	public void updateVehiculo (final Vehiculo empleado);	
	
	public void deleteVehiculo (final Vehiculo empleado);
	
	public Vehiculo searchByMatricula(String matricula);
	
}
