package org.iesalixar.servidor.model;

import java.io.Serializable;

public class ProductLine implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String productLine, textDescription, htmlDescription;

	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	
	
}
