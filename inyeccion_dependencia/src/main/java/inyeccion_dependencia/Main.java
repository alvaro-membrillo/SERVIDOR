package inyeccion_dependencia;

public class Main {

	public static void main(String[] args) {

		Locomotora l1 = new Locomotora("BMW", 5000, 5);
		Maquinista m1 = new Maquinista("Pepe", "Perez", "Aqui", "pepe@gmail.com");
		MaquinistaPrimera m2 = new MaquinistaPrimera("Pepe", "Perez", "Aqui", "pepe@gmail.com", 5);

		Tren tren = new Tren("AVE", m1, l1);

	}

}
