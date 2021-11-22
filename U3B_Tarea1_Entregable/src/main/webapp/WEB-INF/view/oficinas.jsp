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
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<!-- Solo saco el formulario de login si no tengo sesion -->
				<c:if test="${sessionScope.usuario==null}">
					<form method="post">
						<label for="usuario" class="form-label">Oficina</label>
						
						<select name="cities">
						<c:forEach items="${oficinas}" var="o">
							<option>${o.city}</option>
						</c:forEach>
						</select>
						
						<input type="text" class="form-control" id="usuario" name="usuario"
							required> <label for="password" class="form-label mt-3">Password</label>
						
						<input type="submit" class="btn btn-primary w-100 mt-3"
							value="OBTENER DATOS" />
					</form>
					<p>DATOS DE LA OFICINA DE SAN FRANCISCO</p>
					<p class="text-primary text-center mt-3">
						<a href="Register">¿No tienes cuenta? Regístrate</a>
					</p>
				</c:if>
				<c:if test="${sessionScope.usuario!=null}">
					<img class="img-fluid" src="img/portada.jpg" />
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>