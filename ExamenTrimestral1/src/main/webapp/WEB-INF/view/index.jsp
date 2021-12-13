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
	<jsp:include page="include/barra.jsp" />
	<div
		class="row d-flex justify-content-center align-items-center mt-5 mb-5">
		<c:choose>
			<c:when test="${sessionScope.role=='usuario'}">
				<h1>Categorias disponibles</h1>				
				<ul name="productos">
				<c:forEach items="${productos}" var="p">
					<li>${p.productLine}</li>
				</c:forEach>
				</ul>
			</c:when>
			<c:when test="${sessionScope.role=='admin'}">
				<h1>Operaciones disponibles</h1>
				<ul>
					<li>Mostrar Empleados</li>
					<li>Añadir Empleado</li>
				</ul>
			</c:when>
		</c:choose>
	</div>
</body>
</html>