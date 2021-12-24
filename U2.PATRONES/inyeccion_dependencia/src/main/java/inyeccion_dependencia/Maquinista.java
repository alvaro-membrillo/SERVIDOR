package inyeccion_dependencia;

public class Maquinista {
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	
	public Maquinista(String nombre, String apellidos, String direccion, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Maquinista [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + "]";
	}
	
	
	
}
