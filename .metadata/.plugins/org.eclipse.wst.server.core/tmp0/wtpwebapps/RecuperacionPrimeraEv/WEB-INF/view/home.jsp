<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>

	<jsp:include page="include/barra.jsp" />

	<div class="container mt-5">

		<c:if test="${sessionScope.role eq 'admin'}">
			<div class="row col-3 justify-contents-right">
				<a href="${pageContext.request.contextPath}/Admin/AddCustomer"
					class="btn btn-primary">AÑADIR CUSTOMER</a>
			</div>
		</c:if>


		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Número del cliente</th>
							<th>Nombre del cliente</th>
							<th>Nombre del contacto</th>
							<th>Apellidos del contacto</th>
							<th>Teléfono</th>
							<th>Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaCustomers}" var="c">
							<tr>
								<td>${c.customerNumber}</td>
								<td>${c.customerName}</td>
								<td>${c.contactLastName}</td>
								<td>${c.contactFirstName}</td>
								<td>${c.phone}</td>

								<c:if test="${sessionScope.role eq 'usuario'}">
									<td><a
										href="CustomerReport?customerNumber=${c.customerNumber}"><i
											class="bi bi-eye-fill"></i></a></td>
								</c:if>
								<c:if test="${sessionScope.role eq 'admin'}">
									<td><a
										href="Admin/ChangeAssigment?customerNumber=${c.customerNumber}"><i
											class="bi bi-people-fill"></i></a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>

	<c:if test="${sessionScope.role eq 'admin'}">
		<div class="row col-3 justify-contents-right">
			<a href="${pageContext.request.contextPath}/Admin/AddCustomer"
				class="btn btn-primary">AÑADIR CUSTOMER</a>
		</div>
	</c:if>

</body>
</html>