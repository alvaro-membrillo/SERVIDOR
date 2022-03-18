<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir Producto</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
	
		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<form method="post">
					<label for="customerNumber mt-3" class="form-label">Product Code</label>
					<input type="text" class="form-control" id="productCode" name="productCode" required >	
					<label for="checkNumber" class="form-label mt-3">Product Name</label>
    				<input type="text" class="form-control" id="productName" name="productName" required >	
    				<label for="paymentDate" class="form-label mt-3">Product Line</label>
    					<select class="form-select" id="productLines" name="productLines">
						<c:forEach  items="${productLines}" var="pl">
							<option value="${pl.productLine}">${pl.productLine}</option>
						</c:forEach>
					</select>
					<br>
    				<label for="amount" class="form-label mt-3">Product Scale</label>
    				<input type="text" class="form-control" id="extension" name="productScale" required>
    				<label for="amount" class="form-label mt-3">Product Vendor</label>
    				<input type="text" class="form-control" id="puesto" name="productVendor" required>
    				<label for="amount" class="form-label mt-3">Product Description</label>
    				<input type="text" class="form-control" id="puesto" name="productDescription" required>
    				<label for="amount" class="form-label mt-3">Stock</label>
    				<input type="number" class="form-control" id="jefe" name="stock" required>
    				<label for="amount" class="form-label mt-3">Buy Price</label>
    				<input type="number" class="form-control" id="jefe" name="buyPrice" required>
    				<label for="amount" class="form-label mt-3">MSRP</label>
    				<input type="number" class="form-control" id="jefe" name="msrp" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="CREATE PRODUCT" />					
				</form>
			</div>
		</div>
	</div>
</body>
</html>