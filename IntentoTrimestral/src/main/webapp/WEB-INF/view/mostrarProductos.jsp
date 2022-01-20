<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="include/barra.jsp" />
	<div class="container mt-5">

		<c:if test="${requestScope.categoria!=null}">
			<div class="row justify-content-center">
				<div class="col-10">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Descripción</th>
								<th>Fabricante</th>
								<th>Precio Compra</th>
								<th>Stock</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productos}" var="p">

								<tr>
									<td>${p.productName}</td>
									<td>${p.productDescription}</td>
									<td>${p.productVendor}</td>
									<td>${p.buyPrice}</td>
									<td>${p.quantityInStock}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
		<c:if test="${requestScope.categoria eq null}">
			<p>Categoría NO SELECCIONADA</p>
		</c:if>
	</div>

</body>
</html>