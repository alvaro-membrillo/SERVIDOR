<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<jsp:include page="include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="listaPedidos"/></title>
</head>
<body>

	<jsp:include page="include/barra.jsp" />
	<div class="container mt-5">

		<div class="row justify-content-center">
			<div class="col-4">
				<h1><fmt:message key="listaPedidos"/></h1>
			</div>

		</div>

		<!--<div class="row justify-content-end">
			<div class="col-2">
				<a class="btn btn-primary w-100" href="AddEmpleado">AÑADIR
					EMPLEADO</a>
			</div>
		</div>-->
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><fmt:message key="orderNumber"/></th>
							<th><fmt:message key="orderDate"/></th>
							<th><fmt:message key="shippedDate"/></th>
							<th><fmt:message key="status"/></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pedidos}" var="p">
							<tr>
								<td>${p.orderNumber}</td>
								<td>${p.orderDate}</td>
								<td>${p.shippedDate}</td>
								<td>${p.status}</td>
								<c:if test="${sessionScope.rol=='admin'}">
								<td><a href="/Admin/ChangeOrderCustomer?orderNumber={p.orderNumber}"><i class="bi bi-people-fill"></i></a></td>
								</c:if>
								<c:if test="${sessionScope.rol=='user'}">
								<td><a href="/OrderReportServlet"><i class="bi bi-eye-fill"></i></a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>