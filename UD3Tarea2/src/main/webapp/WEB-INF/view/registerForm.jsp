<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- La carpeta con todos los archivos estáticos: CSS, JS, img, etc deben de colgar de la carpeta webapp -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta charset="UTF-8">
<!-- incluimos las librerias necesarias para que podamos ejecutar bootstrap (archivos CSS y jQuery) -->
<jsp:include page="bootstrap/bootstrap.jsp" />
<title>Register Form</title>
</head>
<body>

	<div class="mask d-flex align-items-center gradient-custom-3">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center mt-4 mb-5">
				<div class="col-12 col-md-9 col-lg-7 col-xl-6">
					<div class="card" style="border-radius: 15px;">
						<div class="card-body p-5">
							<!-- Aquí creamos una fila donde vamos a establecer un efecto neon -->
							<div class="row">

								<div class="col-12">

									<div class="neons col-12">
										<h2 class="text-uppercase text-center mb-5">
											<em>Create an account</em>
										</h2>
									</div>

								</div>

							</div>

							<form action="Register" method="post">

								<div class="form-outline mb-4">

									<label class="form-label" for="username">Username</label> <input
										type="text" name="username" id="username"
										class="form-control form-control-lg mb-4" required />

								</div>

								<!-- input text para el correo electrónico -->
								<div class="form-outline mb-4">
									<label class="form-label" for="email">Your Email</label> <input
										type="email" name="email" id="email"
										class="form-control form-control-lg" required />
								</div>

								<!-- input text para la contraseña -->
								<div class="form-outline mb-4">
									<label class="form-label" for="password">Password</label> <input
										type="password" name="password" id="password"
										class="form-control form-control-lg" required />
								</div>

								<!-- Boton de registro el cual lleva al servlet de Registo -->
								<div class="d-flex justify-content-center">
									<button type="submit"
										class="col-12 btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
								</div>

								<!-- Boton de registro el cual lleva al servlet de Login -->
								<p class="text-center text-muted mt-5 mb-0">
									Have already an account? <a href="Login"
										class="fw-bold text-body"><span
										class="text-primary text-decoration-underline">Login
											here</span></a>
								</p>

							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>

</html>