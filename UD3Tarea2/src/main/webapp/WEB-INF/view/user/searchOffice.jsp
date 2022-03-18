<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda de Productos</title>
<jsp:include page="../bootstrap/bootstrap.jsp" />
<fmt:setBundle basename="interface" />
</head>
<body>
	
	<div class="container">
		<jsp:include page="../include/barraUser.jsp"></jsp:include>

		<div class="row justify-content-center">
					<div class="col-6">
					
						<form method="post">
						
							<div class="form-group">
							    <label for="oficinas">Oficina</label>
							    <select class="form-control" id="oficinas" name="busqueda">
								    <c:forEach  var="o" items="${officeList}">
								    	<!-- Si la ciudad del Select coincide con la ciudad de la busqueda hago que se seleccione  -->
								    	<c:choose>
								    	
								    		<c:when test="${o.city eq office.city}">
								    	
								    			<option value="${o.city}" selected>${o.city}</option>
								    	
								    		</c:when>
								    		
								    		<c:otherwise>
								    	
								    			<option value="${o.city}">${o.city}</option>
								    	
								    		</c:otherwise>
								    	
								    	</c:choose>							    	
								    	
									</c:forEach>
							    </select>
							    
							    <button type="submit" name="submit" class="btn btn-primary mt-4">OBTENER DATOS</button>
							</div>							
						
						</form>
					
					</div>
					
					<!-- Solo cargo los datos de la oficina si vengo de un POST -->
					
					<c:if test="${pageContext.request.method=='POST'}">
					
						<jsp:include page="../include/officeCard.jsp" />																	
					
					</c:if>
						

		</div>
	</div>
</body>
</html>