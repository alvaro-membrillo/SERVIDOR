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
		<jsp:include page="../include/barraUser.jsp"></jsp:include>

		<div class="row justify-content-center">
			<div class="col-12 col-md-8 col-lg-6 pb-5">

				<a href="${pageContext.request.contextPath}/User/Search"><i
					class="bi bi-box-arrow-left">Volver</i></a>
				<!--Form with header-->

				<form>
					<div class="card border-dark rounded-1">
						<div class="card-header p-0">
							<div class="bg-primary text-white text-center py-2">
								<h3>View Office</h3>
							</div>
						</div>
						<div class="card-body p-3">

							<!--Body-->
							<div class="form-group">
								<div class="mb-2">

									<label for="pCode" class="form-label fw-bold">Office
										Code</label> <input type="text" name="pCode" class="form-control"
										id="pCode" value="${office.officeCode}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="pName" class="form-label fw-bold">City</label> <input
										type="text" name="pName" class="form-control" id="pName"
										value="${office.city}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="pLine" class="form-label fw-bold">Phone</label> <input
										type="text" name="pLine" class="form-control" id="pLine"
										value="${office.phone}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="pScale" class="form-label fw-bold">Address
										Line 1</label> <input type="text" name="pScale" class="form-control"
										id="pScale" value="${office.addressLine1}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="pVendor" class="form-label fw-bold">Address
										Line 2</label> <input type="text" name="pVendor" class="form-control"
										id="pVendor" value="${office.addressLine2}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="pDescription" class="form-label fw-bold">State</label>
									<input type="text" name="pDescription" class="form-control"
										id="pDescription" value="${office.state}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="quantity" class="form-label fw-bold">Country</label>
									<input type="text" name="quantity" class="form-control"
										id="quantity" value="${office.country}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="buy" class="form-label fw-bold">Postal Code</label>
									<input type="text" name="buy" class="form-control" id="buy"
										value="${office.postalCode}" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="mb-2">
									<label for="msrp" class="form-label fw-bold">Territory</label>
									<input type="text" name="msrp" class="form-control mb-4"
										id="msrp" value="${office.territory}" readonly>
								</div>
							</div>

						</div>

					</div>
				</form>


			</div>
		</div>
	</div>
</body>
</html>