<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<jsp:include page="../include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir Producto</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp" />
	<div class="container mt-5">


		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<h1>Change Product Customer</h1>
				<h4>Order code:</h4>
				<form method="post">
					<label for="customerNumber mt-3" class="form-label">Customer</label>
					<select>
						<c:forEach items="${objetoProductLine}" var="pl">
							<option value="${pl.productLine}">${pl.productLine}</option>
						</c:forEach>
					</select> <br> <input type="submit" class="btn btn-primary w-100 mt-3"
						value="CHANGE CUSTOMER" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>