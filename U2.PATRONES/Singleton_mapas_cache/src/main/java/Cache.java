import java.util.HashMap;
import java.util.Map;

public class Cache {
	
	//Este es el singleton, una variable de clase
	private static Map<String,String> cache = null;
	// hay que meterlo en una clase para garantizar que solo hay una copia
	
	public static Map<String,String> getCache() {
		if (cache == null) {
			cache = new HashMap<String,String>();
		}
		
		return cache;
	}

}
