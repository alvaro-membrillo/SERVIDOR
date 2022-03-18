<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<jsp:include page="../bootstrap/bootstrap.jsp" />
<fmt:setBundle basename="interface" />
</head>
<body>
	
	<div class="container">
		<jsp:include page="../include/barraUser.jsp"></jsp:include>
		<div class="row justify-content-center">
			
			<div class="col-6 m-4">
				<img src="../img/coche.jpg" class="img-fluid" alt="car">
			</div>

		</div>
	</div>
</body>
</html>