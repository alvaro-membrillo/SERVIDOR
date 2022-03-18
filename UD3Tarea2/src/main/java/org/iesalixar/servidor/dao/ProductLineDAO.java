package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.ProductLine;

public interface ProductLineDAO {

	public List<ProductLine> getAllProductLines();

	public ProductLine getProductLine(String productLine);
	
	public boolean updateProductLine(ProductLine product);
	
	public boolean deleteProductLine(String productLine);
	
	public boolean addProductLine(ProductLine product);

	
}
