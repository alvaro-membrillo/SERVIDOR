package practica_ej2_PatronFactory;

public abstract class Figura {
	
	private String tipo;
	private String color;
	
	public Figura(String tipo, String color) {
		this.tipo = tipo;
		this.color = color;
	}
	
	public void dibujarFigura() {
		
	}

	@Override
	public String toString() {
		return "Figura [tipo=" + tipo + ", color=" + color + "]";
	}
	
	
}
