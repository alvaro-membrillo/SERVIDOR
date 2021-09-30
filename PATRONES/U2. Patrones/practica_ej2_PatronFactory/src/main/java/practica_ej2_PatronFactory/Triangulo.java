package practica_ej2_PatronFactory;

public class Triangulo extends Figura {

	public Triangulo(String tipo, String color) {
		super(tipo, color);
	}
	
	public void dibujarFigura() {
		System.out.println("Triangulo");
	}
	
	
}
