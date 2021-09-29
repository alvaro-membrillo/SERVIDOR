package inyeccion_dependencia;

public class Tren {
	
	private String modelo;
	private Locomotora locomotora;
	private Maquinista maquinista;

	public Tren(String modelo, Maquinista maquinista, Locomotora locomotora) {
		this.modelo = modelo;
		this.locomotora = locomotora;
		this.maquinista = maquinista;
	}
	

	@Override
	public String toString() {
		return "Tren [modelo=" + modelo + "]";
	}
	

}
