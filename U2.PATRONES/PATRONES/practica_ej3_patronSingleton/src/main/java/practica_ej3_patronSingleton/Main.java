package practica_ej3_patronSingleton;

public class Main {

	public static void main(String[] args) {
		
		Presidente p1 = Presidente.getPresidente("Joe", "Biden", 2021);
		Presidente p2 = Presidente.getPresidente("Donald", "Trump", 2016);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		System.out.println(p1.equals(p2));
		
	}

}
