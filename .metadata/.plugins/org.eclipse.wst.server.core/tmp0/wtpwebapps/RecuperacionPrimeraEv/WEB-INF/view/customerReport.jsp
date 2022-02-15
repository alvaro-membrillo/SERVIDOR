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

		<div class="row justify-content-center">
			<div class="col-10">
				<c:if test="${customer != null}">
					<p>Nombre del cliente: ${customer.customerName}</p>
					<p>Total de pagos:</p>
					<p>Número de pedidos:</p>
				</c:if>
				<c:if test="${customer == null}"> 
					<p>CLIENTE NO SELECCIONADO</p>
					<a href="${pageContext.request.contextPath}/Home">Pagina de inicio</a>
				</c:if>
			</div>
		</div>

	</div>

</body>
</html>