<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.iesalixar.servidor.model.Customer" import="java.util.ArrayList" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>	
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<td><fmt:message key="name" /></td>
						<td><fmt:message key="city" /></td>
						<td><fmt:message key="state" /></td>
						<td><fmt:message key="postalCode" /></td>
						<td><fmt:message key="country" /></td>	
					</thead>
					<tbody>
						<% for (Customer c:(ArrayList<Customer>)request.getAttribute("customers")) { %>
							<tr>
								<td><a href="ClientInfo?customerId=<%= c.getCustomerNumber() %>"><%= c.getCustomerName() %></a></td>
								<td><%= c.getCity() %></td>
								<td><%= c.getState() %></td>
								<td><%= c.getPostalCode() %></td>
								<td><%= c.getCountry() %></td>
							<tr>								
						<% } %>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>