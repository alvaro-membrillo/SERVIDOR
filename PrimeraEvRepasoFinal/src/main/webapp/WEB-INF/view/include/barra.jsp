
  
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />

<c:if test="${sessionScope.usuario!=null }">

	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: blue">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link text-white"
						href="${pageContext.request.contextPath}">Inicio</a></li>
					<c:if test="${sessionScope.role=='usuario'}">
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/Oficinas">Oficinas</a></li>
					</c:if>
				</ul>
				<span class="navbar-text d-flex text-white"><i
						class="bi bi-person"></i> <c:out value="${sessionScope.usuario}" /></a>
					<a class="text-white"
					href="${pageContext.request.contextPath}/LogOut"><i
						class="bi bi-box-arrow-left"></i></a></span>
			</div>
		</div>
	</nav>

</c:if>