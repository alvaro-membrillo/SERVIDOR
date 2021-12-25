package daoproductline;

import java.util.List;

public interface ProductLineDao {	
		
	ProductLine getProductLine(String name);
	List<ProductLine> getProductLines();
	void deleteProductLine(String name);	

}
