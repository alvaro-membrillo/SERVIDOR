package inyeccion_dependencia;

public class MaquinistaPrimera extends Maquinista {
	
	private int antiguedad;
	
	public MaquinistaPrimera(String nombre, String apellidos, String direccion, String email, int antiguedad) {
		super(nombre, apellidos, direccion, email);
		this.antiguedad = antiguedad;
	}

	
	@Override
	public String toString() {
		return "MaquinistaPrimera [antiguedad=" + antiguedad + "]";
	}	
	
}
