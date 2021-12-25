<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.usuario!=null}">
	<div class="row justify-center-end bg-primary text-white">

		<div class="col-10">
			<p>
				<c:out value="${sessionScope.usuario}"></c:out>
					<a href="LogOut"><i class="bi bi-box-arrow-left text-white"></i></a>
				
			</p>
		</div>
	</div>
</c:if>