
public abstract class Pizza {
	
	private String nombre;
	
	public Pizza(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String sayIngredientes();
	
}
