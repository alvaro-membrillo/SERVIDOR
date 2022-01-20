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
						<h1 class="nav-item justify-content-center">Zona de usuario</h1>
					</c:when>
					<c:when test="${sessionScope.role eq 'admin'}">
						<!--<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}">Inicio</a></li>-->
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/Admin/AddCustomer">Añadir
								cliente</a></li>


						<li class="nav-item text-center">Zona de administracion</li>

					</c:when>
				</c:choose>
			</ul>

			<h1>
				<a href="Logout"><i class="bi bi-box-arrow-left text-white"></i></a>
			</h1>
		</div>
	</nav>

</c:if>