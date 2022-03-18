<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Propiedades</title>
</head>
<body>
	<h1>Lista de Propiedades del bd.properties</h1>
	<ul>
		<%
			ArrayList<String> listaPropiedades = (ArrayList<String>)request.getAttribute("propiedades");
			out.println(listaPropiedades.toString());
		%>
	</ul>
</body>
</html>