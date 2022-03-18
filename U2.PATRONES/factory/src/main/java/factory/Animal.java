package factory;

public abstract class Animal {

	private String nombre;
	
	public Animal (String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public abstract String saludar();

}
