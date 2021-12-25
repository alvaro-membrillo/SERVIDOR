<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
<jsp:include page="../bootstrap/bootstrap.jsp" />
<fmt:setBundle basename="interface" />
</head>
<body>

	<div class="container">
		<jsp:include page="../include/barraAdmin.jsp"></jsp:include>

		<div class="row justify-content-center m-5">
			<div class="col-12">

				<c:choose>
					<c:when test="${productList != null and productList.size() > 0}">
						<table class="table table-dark table-striped table-hover">
							<thead>
								<tr>
									<th>Nombre</th>
									<th>Categoría</th>
									<th>Descripción</th>
									<th>Precio</th>
									<th>Acción</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productList}" var="p">
									<tr>
										<td>${p.productName}</td>
										<td>${p.productLine}</td>
										<td>${p.productDescription}</td>
										<td>${p.buyPrice}</td>
										<td><a class="bi bi-pencil-fill text-white"
											href="${pageContext.request.contextPath}/Admin/Product?productName=${p.productName}"></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:when test="${productList != null and productList.size()==0}">
						<p class="text-danger">NO HAY RESULTADOS</p>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>