<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.username!=null}">
	
	<div class="d-flex bg-primary p-2 m-2 text-white">
			
			<div class="d-flex">
			
				<a class="text-white m-2 text-decoration-none enlace" href="${pageContext.request.contextPath}/Admin/Inicio">Inicio</a> 
			
			</div>			
					
			<div class="d-flex ms-auto">
				
				<p class="m-2">
						
						Esta usted logeado como:&nbsp; 
						<c:out value="${sessionScope.username}" />
						<a class="text-white m-3 text-decoration-none"
							href="${pageContext.request.contextPath}/LogOut"><i
							class="bi bi-box-arrow-left m-1"></i>Salir</a>
				</p>
			
			</div>
			

		</div>

</c:if>