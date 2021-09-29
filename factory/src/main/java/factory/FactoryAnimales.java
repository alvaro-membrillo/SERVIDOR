package factory;

public class FactoryAnimales {
	
	public static Animal getAnimal(String tipo, String nombre) {
		
		if (tipo.equals("perro")) {
			return new Perro(nombre);
		} else if (tipo.equals("gato")) {
			return new Gato(nombre);
		} else {
			return new Vaca(nombre);
		}
		
	}

}
