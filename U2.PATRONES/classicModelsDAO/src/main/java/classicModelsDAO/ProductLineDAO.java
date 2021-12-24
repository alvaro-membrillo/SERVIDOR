package classicModelsDAO;

import java.util.List;

public interface ProductLineDAO {
	ProductLine getProductLine(String productLineID);
	List<ProductLine> getProductLine();
	void createNewProductLine(ProductLine productLine);
	void deleteProductLine(int productLineID);
}
