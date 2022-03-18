package factory;

public class Gato extends Animal {
	
	public Gato(String nombre) {
		super(nombre);
	}
	
	@Override
	public String saludar() {
		return "MIAU!!";
	}
	
}
