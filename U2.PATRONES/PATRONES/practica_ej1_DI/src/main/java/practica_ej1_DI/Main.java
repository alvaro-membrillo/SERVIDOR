package practica_ej1_DI;

public class Main {

	public static void main(String[] args) {

		Tejado t1 = new Tejado();

		// Creamos las cuatro paredes
		Pared p1 = new Pared(4);
		Pared p2 = new Pared(4);
		Pared p3 = new Pared(4);
		Pared p4 = new Pared(4);

		Casa c1 = new Casa(t1, p1, p2, p3, p4);
		
		c1.darSoporte();
		
		Tejado t2 = new Tejado();

		// Creamos las cuatro paredes
		Pared p5 = new Pared(5);
		Pared p6 = new Pared(5);
		Pared p7 = new Pared(5);
		Pared p8 = new Pared(5);

		Casa c2 = new Casa(t2, p5, p6, p7, p8);
		
		c2.darSoporte();
		
	}

}
