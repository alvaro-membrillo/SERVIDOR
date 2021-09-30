package practica_ej1_DI;

public class Casa extends Tejado {
	
	private Tejado tejado;
	private Pared paredA;
	private Pared paredB;
	private Pared paredC;
	private Pared paredD;
	
	public Casa(Tejado tejado, Pared paredA, Pared paredB, Pared paredC, Pared paredD) {
		this.tejado = tejado;
		
		this.paredA = paredA;
		this.paredB = paredB;
		this.paredC = paredC;
		this.paredD = paredD;
	}
	
}
