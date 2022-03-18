package singleton_deposito;

public class Deposito {

	private static int cantidad = 0;
	private static Deposito deposito = null;

	public Deposito() { // Constructor
		System.out.println("Soy un depósito");
	}

	public static Deposito getDeposito() {
		if (deposito == null) {
			// No se usa this. porque es un objeto estático
			deposito = new Deposito();
		}

		return deposito;
	}

	public static int llenar(int numLitros) {
		Deposito.cantidad += numLitros;
		System.out.println(Deposito.cantidad);
		
		return Deposito.cantidad;
	}

	public static int vaciar(int numLitros) {
		Deposito.cantidad -= numLitros;
		System.out.println(Deposito.cantidad);

		return Deposito.cantidad;
	}
	
	public static int getCantidad() {
		return Deposito.cantidad;
	}

}
