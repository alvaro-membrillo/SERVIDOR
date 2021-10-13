package practica_ej2_PatronFactory;

public class Main {

	public static void main(String[] args) {
		
		Figura circulo = FiguraFactory.dibujaFigura("circulo", "azul");
		Figura cuadrado = FiguraFactory.dibujaFigura("cuadrado", "rojo");
		Figura rectangulo = FiguraFactory.dibujaFigura("rectangulo", "verde");
		Figura triangulo = FiguraFactory.dibujaFigura("triangulo", "morado");
		
		System.out.println(circulo.toString());
		System.out.println(cuadrado.toString());
		System.out.println(rectangulo.toString());
		System.out.println(triangulo.toString());
	}

}
