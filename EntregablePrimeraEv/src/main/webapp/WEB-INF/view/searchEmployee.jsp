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
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<form method="post" class="d-flex">
				<input name="busqueda" class="form-control me-2" type="search"
					placeholder="Search" />
				<button class="btn btn-outline-success" type="submit">Buscar</button>
			</form>
		</nav>
		<div class="row justiy-content-center">
			<c:choose>
				<c:when test="${employees!=null and employees.size()>0}">
					<table>
						<thead>
							<tr>
								<th>firstName</th>
								<th>lastName</th>
								<th>email</th>
								<th>jobTitle</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${employees}" var="e">
								<tr>
									<td>${e.firstName}</td>
									<td>${e.lastName}</td>
									<td>${e.email}</td>
									<td>${e.jobTitle}</td>
									<td><a href="view?view=${e.employeeNumber}"><i
											class="bi bi-eye-fill"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:when test="${employees!=null and employees.size()==0}">
					<p class="text-danger">NO HAY RESULTADOS</p>
				</c:when>

			</c:choose>
		</div>
	</div>
</body>
</html>