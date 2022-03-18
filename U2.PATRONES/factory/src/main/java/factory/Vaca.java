package factory;

public class Vaca extends Animal {
	
	public Vaca (String nombre) {
		super(nombre);
	}
	
	@Override
	public String saludar() {
		return "MUUU!!";
	}
}
