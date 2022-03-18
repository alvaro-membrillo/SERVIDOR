<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-10">
				<h1 class="bg-primary text-white text-center">Lista de Empleados</h1>
				<table class="table table-stripped table-hover">
					<thead>
						<tr class="table-dark">
							<th>number</th>
							<th>lastname</th>
							<th>firstname</th>
							<th>email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${empleados}" var="empleado">
							<tr>
								<td>${empleado.employeeNumber}</td>
								<td>${empleado.lastName}</td>
								<td>${empleado.firstName}</td>
								<td>${empleado.email}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>