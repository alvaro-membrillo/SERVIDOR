package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.ProductDAOImpl;
import org.iesalixar.servidor.dao.ProductLineDAOImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class SeeProduct
 */
@WebServlet("/Admin/Product")
public class ProductServlet extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(ProductServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("product", new ProductDAOImpl().getProduct(request.getParameter("productName")));
		request.setAttribute("productLines", new ProductLineDAOImpl().getAllProductLines());
		request.getRequestDispatcher("/WEB-INF/view/admin/seeProduct.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String productCode = (String) request.getParameter("pCode");
		String productName = (String) request.getParameter("pName");
		String productLine = (String) request.getParameter("pLine");
		String productScale = (String) request.getParameter("pScale");
		String productVendor = (String) request.getParameter("pVendor");
		String productDescription = (String) request.getParameter("pDescription");
		String quantity = (String) request.getParameter("quantity");
		String buy = (String) request.getParameter("buy");
		String msrp = (String) request.getParameter("msrp");
		
		if(productName != null && productLine != null && productScale != null
				&& productVendor != null && productDescription != null && quantity != null && buy != null && msrp != null) {
			
			Product p = new Product();
			p.setProductName(productName);
			p.setProductLine(productLine);
			p.setProductScale(productScale);
			p.setProductVendor(productVendor);
			p.setProductDescription(productDescription);
			p.setQuantityInStock(Integer.parseInt(quantity));
			p.setBuyPrice(Double.parseDouble(buy));
			p.setMsrp(Double.parseDouble(msrp));
			
			if(new ProductDAOImpl().updateProduct(p, productCode)) {
							
				logger.info("updateProduct the product has been updated successfuly [ProductServlet.class]");
				response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
				
			} else {
				
				logger.info("updateProduct cannot update the product [ProductServlet.class]");
				response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
				
			}
			
		} else {
			
			logger.info("cannot set a null [ProductServlet.class]");
			response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
		}
		
		
	}

}
