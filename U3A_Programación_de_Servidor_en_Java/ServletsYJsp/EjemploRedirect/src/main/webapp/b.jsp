<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HOLA ESTOY EN B</h1>
	
	<jsp:useBean id="usuario" scope="request" class="org.iesalixar.servidor.model.Usuario" />
	<%= (String)request.getParameter("destino") %>
	
	<p>Usuario: <%= usuario.getUsuario() %></p>
</body>
</html>