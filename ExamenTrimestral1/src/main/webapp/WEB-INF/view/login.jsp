<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div
			class="row d-flex justify-content-center align-items-center mt-5 mb-5">
			<div class="col-12 col-md-9 col-lg-7 col-xl-6">
				<div class="card">
					<div class="card-body p-5">
						<div class="row">
							<div class="col-12">
								<h2 class="text-uppercase text-center mb-5">Login</h2>
							</div>

						</div>

						<form method="post">

							<div class="form-outline mb-4">
								<label class="form-label" for="email">Email</label>
								<input type="email" name="email" class="form-control form-control-lg mb-4" autofocus />
							</div>

							<div class="form-outline mb-4">
								<label class="form-label" for="password">Password</label> <input
									type="password" name="password" class="form-control form-control-lg" />
							</div>

							<c:if test="${error!=null}">
								<p class="text-danger text-small mt-3">${error}</p>
							</c:if>

							<div class="d-flex justify-content-center">
								<button type="submit"
									class="col-12 btn btn-info btn-block btn-lg text-body">Login</button>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>