package practica_ej2_PatronFactory;

public class FiguraFactory {

	public static Figura dibujaFigura(String tipo, String color) {

		if (tipo.equals("circulo")) {
			return new Circulo("circulo", color);
		} else if (tipo.equals("cuadrado")) {
			return new Cuadrado("cuadrado", color);
		} else if (tipo.equals("rectangulo")) {
			return new Rectangulo("rectangulo", color);
		} else if (tipo.equals("triangulo")){
			return new Triangulo("triangulo", color);
		} else {
			return null;
		}

	}

}
