package practica_ej3_patronSingleton;

public class Presidente {

	private static String nombre;
	private static String apellidos;
	private static int anyoEleccion;

	private static Presidente presidente;

	private Presidente(String nombre, String apellidos, int anyoEleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anyoEleccion = anyoEleccion;
	}

	public static Presidente getPresidente(String nombre, String apellidos, int anyoEleccion) {
		if (presidente == null) {
			presidente = new Presidente(nombre, apellidos, anyoEleccion);
		}

		return presidente;
	}

	@Override
	public String toString() {
		return "Presidente [nombre=" + nombre + ", apellidos=" + apellidos + ", anyoEleccion=" + anyoEleccion + "]";
	}
	
	
	

}
