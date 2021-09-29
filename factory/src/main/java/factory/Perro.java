package factory;

public class Perro extends Animal {
	
	
	public Perro (String nombre) {
		super(nombre);
	}
	
	@Override
	public String saludar() {
		return "Guauu!!";
	}
}
