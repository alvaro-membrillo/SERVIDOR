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

	<c:if test="${sessionScope.role eq 'usuario'}">
		<h1>Categorías disponibles</h1>

		<ul>
			<c:forEach items="${categorias}" var="c">
				<li><a href="${pageContext.request.contextPath}/MostrarProductos?cat=${c.productLine}">${c.productLine}</a></li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${sessionScope.role eq 'admin'}">
		<h1>Operaciones disponibles</h1>
		<li><a href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar Empleados</a></li>
		<li><a href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a></li>
	</c:if>
</body>
</html>