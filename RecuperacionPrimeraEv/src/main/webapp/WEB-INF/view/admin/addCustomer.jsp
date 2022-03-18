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
				<form method="post">
					<label for="customerNumber mt-3" class="form-label">Número
						de cliente</label> <input type="text" class="form-control"
						id="customerNumber" name="customerNumber" required> <label
						for="checkNumber" class="form-label mt-3">Nombre del
						cliente</label> <input type="text" class="form-control" id="customerName"
						name="customerName" required> <label for="contactLastName"
						class="form-label mt-3">Nombre de la persona de contacto</label> <input
						type="text" class="form-control" id="contactFirstName"
						name="contactFirstName" required> <label for="amount"
						class="form-label mt-3">Apellido de la persona de contacto</label>
					<input type="text" class="form-control" id="extension"
						name="contactLastName" required> <label for="amount"
						class="form-label mt-3">Teléfono</label> <input type="text"
						class="form-control" id="phone" name="phone" required> <label
						for="amount" class="form-label mt-3">Dirección 1</label> <input
						type="text" class="form-control" id="addressLine1"
						name="addressLine1" required> <label for="addressLine2"
						class="form-label mt-3">Dirección 2</label> <input type="text"
						class="form-control" id="addressLine2" name="addressLine2"
						required> <label for="city" class="form-label mt-3">Ciudad</label>
					<input type="text" class="form-control" id="city" name="city"
						required> <label for="state" class="form-label mt-3">Estado</label>
					<input type="text" class="form-control" id="postalCode"
						name="state" required> <label for="country"
						class="form-label mt-3">CP</label> <input type="text"
						class="form-control" id="postalCode" name="postalCode" required>
					<label for="country" class="form-label mt-3">País</label> <input
						type="text" class="form-control" id="country" name="country"
						required> <label for="amount" class="form-label mt-3">Empleado</label>
					<select class="form-select" id="addressLine1" name="addressLine2">
						<c:forEach items="${listaEmpleados}" var="e">
							<option value="${e.lastName}">${e.lastName+", "+e.firstName}</option>
						</c:forEach>
					</select> <label for="creditLimit" class="form-label mt-3">Límite de
						crédito</label> <input type="int" class="form-control" id="creditLimit"
						name="creditLimit" required> <input type="submit"
						class="btn btn-primary w-100 mt-3" value="AÑADIR" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>