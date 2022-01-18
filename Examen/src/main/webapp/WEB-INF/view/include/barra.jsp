<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="bootstrap.jsp" />

<c:if test="${sessionScope.usuario != null}">

	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: blue">

		<div class="container-fluid text-white">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link text-white"
					href="${pageContext.request.contextPath}/Home">Inicio</a></li>
				<c:choose>
					<c:when test="${sessionScope.role eq 'usuario'}">
						<h1>ZONA DE USUARIO</h1>
					</c:when>
					<c:when test="${sessionScope.role eq 'admin'}">
						<!--<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}">Inicio</a></li>-->
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar
								Empleados</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir
								Empleado</a></li>

						<li class="nav-item">ZONA DE ADMINISTRADOR</li>
					</c:when>
				</c:choose>
			</ul>

			<h1>
				<a href="Logout"><i class="bi bi-box-arrow-left"></i></a>
			</h1>
		</div>
	</nav>

</c:if>