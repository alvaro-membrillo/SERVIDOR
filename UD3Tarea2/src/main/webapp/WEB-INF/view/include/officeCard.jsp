<div class="row justify-content-center">
	<div class="col-12 col-md-8 col-lg-6 pb-5">

		<!--Form with header-->

		<form>
			<div class="card border-dark rounded-1 m-5">
				<div class="card-header p-0">
					<div
						class="bg-primary text-white text-center p-2 d-flex justify-content-center">
						<h3>${office.city}Office</h3>
						<a class="text-white m-2"
							href="${pageContext.request.contextPath}/User/Oficinas"><i
							class="bi bi-box-arrow-left">Volver</i></a>
					</div>
				</div>
				<div class="card-body p-3">

					<!--Body-->
					<div class="form-group">
						<div class="mb-2">

							<label for="pCode" class="form-label fw-bold">Office Code</label>
							<input type="text" name="pCode" class="form-control" id="pCode"
								value="${office.officeCode}" readonly>
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
							<label for="buy" class="form-label fw-bold">Postal Code</label> <input
								type="text" name="buy" class="form-control" id="buy"
								value="${office.postalCode}" readonly>
						</div>
					</div>

					<div class="form-group">
						<div class="mb-2">
							<label for="msrp" class="form-label fw-bold">Territory</label> <input
								type="text" name="msrp" class="form-control mb-4" id="msrp"
								value="${office.territory}" readonly>
						</div>
					</div>

				</div>

			</div>
		</form>
		<!--Form with header-->


	</div>
</div>