package factory;

public class Main {

	public static void main(String[] args) {
		
		Animal a = FactoryAnimales.getAnimal("perro", "Toby");
		
		System.out.println(a.saludar());
	}

}
