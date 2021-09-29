
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza pizza = FactoryPizza.devuelvePizza("Tropical");
		
		System.out.println(pizza.sayIngredientes());
	}

}
