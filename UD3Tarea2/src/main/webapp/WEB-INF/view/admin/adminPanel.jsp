<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>

	.col-2{

		min-height: 98vh;
		border-radius: 10px;		
		
	}
	
	.dashTitle{
	top: 50px;
	}

</style>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta charset="UTF-8">
<jsp:include page="../bootstrap/bootstrap.jsp" />
<title>Login Form</title>
</head>
<body>
	
	<div class="container-fluid">
		
		<h1>Admin Zone</h1>
		<a href="${pageContext.request.contextPath}/Logout" class="bi bi-house btn btn-primary">Logout</a>
		<a href="${pageContext.request.contextPath}/Admin/Product" class="btn btn-primary">Product</a>
		
	</div>

</body>
</html>