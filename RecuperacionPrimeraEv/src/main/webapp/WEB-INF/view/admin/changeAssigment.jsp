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
<title>Añadir clientes</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp" />
	<div class="container mt-5">


		<div class="row justify-content-center mt-3">
			<div class="col-6">
			
			<h2>CLIENTE: </h2>
			<h2>CONTACT EN CLIENTE: </h2>
			
				<form method="post">
					<label for="salesRep" class="form-label mt-3">Empleado
						Asignado</label> <select class="form-select" id="addressLine1"
						name="addressLine2">
						<c:forEach items="${listaEmpleados}" var="e">
							<option value="${e.lastName}">${e.lastName+", "+e.firstName}</option>
						</c:forEach>
					</select>

					<div class="row col-12 justify-contents-center">
						<a href="${pageContext.request.contextPath}/Admin/ChangeAssigment"
							class="btn btn-primary">ASIGNAR EMPLEADO</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>