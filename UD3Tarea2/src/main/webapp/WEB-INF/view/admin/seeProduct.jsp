<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Product</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">
<jsp:include page="../bootstrap/bootstrap.jsp" />
<fmt:setBundle basename="interface" />
</head>
<body>

	<div class="container">
		<jsp:include page="../include/barraAdmin.jsp"></jsp:include>

		<div class="row justify-content-center">
			<div class="col-12 col-md-8 col-lg-6 pb-5">


				<!--Form with header-->
				<form method="post">

					<div class="card border-dark rounded-1">
						<div class="card-header p-0">
							<div
								class="d-flex bg-primary text-white text-center p-2 justify-content-center">
								<h3>${product.productName}</h3>
								<a class="text-white text-decoration-none m-2"
									href="${pageContext.request.contextPath}/Admin/Inicio"><i
									class="bi bi-box-arrow-left">Volver</i></a>
							</div>
						</div>
						<div class="card-body p-3">

							<!--Body-->
							<div class="mb-2">

								<label for="pCode" class="form-label fw-bold"><fmt:message
										key="pCode" /></label> <input type="text" name="pCode"
									class="form-control" id="pCode" value="${product.productCode}"
									readonly>
							</div>

							<div class="mb-2">
								<label for="pName" class="form-label fw-bold"><fmt:message
										key="pName" /></label> <input type="text" name="pName"
									class="form-control" id="pName" value="${product.productName}">
							</div>

							<div class="mb-2">
								<label for="pLine" class="form-label fw-bold"><fmt:message
										key="pLine" /></label> <select class="form-control" id="pLine"
									name="pLine">
									<c:forEach var="pl" items="${productLines}">

										<c:choose>

											<c:when test="${product.productLine eq pl.productLine}">

												<option value="${product.productLine}" selected>${product.productLine}</option>

											</c:when>
											<c:otherwise>

												<option value="${pl.productLine}">${pl.productLine}</option>

											</c:otherwise>

										</c:choose>

									</c:forEach>
								</select>

							</div>


							<div class="mb-2">
								<label for="pScale" class="form-label fw-bold"><fmt:message
										key="pScale" /></label> <input type="text" name="pScale"
									class="form-control" id="pScale"
									value="${product.productScale}">
							</div>

							<div class="mb-2">
								<label for="pVendor" class="form-label fw-bold"><fmt:message
										key="pVendor" /></label> <input type="text" name="pVendor"
									class="form-control" id="pVendor"
									value="${product.productVendor}">
							</div>

							<div class="mb-2">
								<label for="pDescription" class="form-label fw-bold"><fmt:message
										key="pDescription" /></label>
								<textarea class="form-control" style="height: 100px"
									name="pDescription" id="pDescription">${product.productDescription}</textarea>
							</div>

							<div class="mb-2">
								<label for="quantity" class="form-label fw-bold"><fmt:message
										key="quantity" /></label> <input type="text" name="quantity"
									class="form-control" id="quantity"
									value="${product.quantityInStock}">
							</div>

							<div class="mb-2">
								<label for="buy" class="form-label fw-bold"><fmt:message
										key="buy" /></label> <input type="text" name="buy"
									class="form-control" id="buy" value="${product.buyPrice}">
							</div>

							<div class="mb-2">
								<label for="msrp" class="form-label fw-bold"><fmt:message
										key="msrp" /></label> <input type="text" name="msrp"
									class="form-control mb-4" id="msrp" value="${product.msrp}">
							</div>

						</div>

						<button type="submit" class="btn btn-primary m-2">MODIFICAR</button>
					</div>

				</form>


			</div>
		</div>
	</div>
</body>
</html>