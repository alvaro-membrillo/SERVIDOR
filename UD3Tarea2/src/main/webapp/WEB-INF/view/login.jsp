<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!-- incluimos las librerias necesarias para que podamos ejecutar bootstrap (archivos CSS y jQuery) -->
<jsp:include page="bootstrap/bootstrap.jsp" />
<title>Login Form</title>
</head>
<body>

	<div class="container">
		<div
			class="row d-flex justify-content-center align-items-center mt-5 mb-5">
			<div class="col-12 col-md-9 col-lg-7 col-xl-6">
				<div class="card" style="border-radius: 15px;">
					<div class="card-body p-5">
						<!-- Aquí creamos una fila donde vamos a establecer un efecto neon -->
						<div class="row">

							<div class="col-12">


								<h2 class="text-uppercase text-center mb-5">
									<em>Login</em>
								</h2>


							</div>

						</div>

						<form action="Login" method="post">

							<div class="form-outline mb-4">

								<label class="form-label" for="username">Username</label> <input
									type="text" name="username" id="username"
									class="form-control form-control-lg mb-4" autofocus />

							</div>

							<!-- input text para la contraseña -->
							<div class="form-outline mb-4">
								<label class="form-label" for="password">Password</label> <input
									type="password" name="password" id="password"
									class="form-control form-control-lg" />
							</div>

							<c:if test="${error!=null}">
								<p class="text-danger text-small mt-3">${error}</p>
							</c:if>

							<!-- Boton de registro el cual lleva al servlet de Registo -->
							<div class="d-flex justify-content-center">
								<button type="submit"
									class="col-12 btn btn-success btn-block btn-lg text-body">Login</button>
							</div>

							<!-- Boton de registro el cual lleva al servlet de Login -->
							<p class="text-center text-muted mt-5 mb-0">
								You do not have an account? <a href="Register"
									class="fw-bold text-body"><span
									class="text-primary text-decoration-underline">Register
										here</span></a>
							</p>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>