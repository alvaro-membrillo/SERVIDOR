package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface ProductDAO {
	
	public Product getProduct (String productName);
	public ArrayList<Product> getProductSearch(String seachTerm);
	public Product getProductByCode (String orderNumber);
	public ArrayList<Product> getAllProducts();
	public boolean updateProduct(Product p, String productCode);
	public int getDetailsCountFromProduct(String productCode);
	public int getSumProductsFromOrder(String pCode);
	public double getTotalProduct(String pCode);
	
}
