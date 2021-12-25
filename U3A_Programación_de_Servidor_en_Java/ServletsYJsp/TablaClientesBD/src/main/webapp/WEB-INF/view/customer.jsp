<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Información de un Cliente Determinado</title>
<jsp:include page="include/bootstrap.jsp" />
<jsp:useBean id="customer" scope="request"
	class="org.iesalixar.servidor.model.Customer" />
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-5">
				<h1 class="h1">
					Cliente:<jsp:getProperty property="customerName" name="customer" /></h1>
				<ul>
					<li><span class="text-uppercase fw-bold"><fmt:message key="contactFirstName" />: </span><jsp:getProperty
							property="contactFirstName" name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="contactLastName" />: </span><jsp:getProperty
							property="contactLastName" name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="phone" />: </span><jsp:getProperty
							property="phone" name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="address" />: </span><jsp:getProperty
							property="addressLine1" name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="address2" />: </span><jsp:getProperty
							property="addressLine2" name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="city" />: </span><jsp:getProperty property="city"
							name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="state" />: </span><jsp:getProperty property="state"
							name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="postalCode" />: </span><jsp:getProperty property="postalCode"
							name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="country" />: </span><jsp:getProperty property="country"
							name="customer" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="creditLimit" />: </span><jsp:getProperty property="creditLimit"
							name="customer" /></li>							
				</ul>
			</div>
		</div>
	</div>
</body>
</html>