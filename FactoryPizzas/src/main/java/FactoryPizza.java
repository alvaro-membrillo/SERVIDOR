
public class FactoryPizza {

	public static Pizza devuelvePizza(String tipo) {

		if (tipo.equals("barbacoa")) {
			return new Barbacoa("barbacoa");
		} else if (tipo.equals("carbonara")) {
			return new Carbonara("carbonara");
		} else {
			return new Tropical("tropical");
		}
	}
}
