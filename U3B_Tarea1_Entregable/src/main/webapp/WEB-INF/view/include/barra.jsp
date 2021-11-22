<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.usuario!=null}">
	<div class="row justify-center bg-primary text-white">
		<div class="col-6">
			<p>
				<a href="Main" class="text-white">Inicio</a>
				<a href="Oficinas" class="text-white">Buscar Oficinas</a>
			</p>
		</div>
		<div class="col-6">
			<p>Está usted logeado como:
				<c:out value="${sessionScope.firstName}"></c:out>
				<c:out value="${sessionScope.lastName}"></c:out>
			</p>
			<a href="LogOut" class="float-right text-white">Salir</a>
		</div>
	</div>
</c:if>