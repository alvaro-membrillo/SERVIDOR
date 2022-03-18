package singleton_deposito;

public class Cubo {
	
	private int cantidad;
	
	public Cubo (int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void vaciar() {
		Deposito.getDeposito();
		Deposito.llenar(this.cantidad);
		
		this.cantidad = 0;
	}
	
	public void llenar(int cantidad) {
		Deposito.getDeposito();
		Deposito.vaciar(this.cantidad);
	}
	
}
