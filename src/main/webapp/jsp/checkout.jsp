<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="mainHeads.jsp"></jsp:include>
<link href="<c:url value='/css/checkout.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>

	<div class="container">

		<div class="row">

			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Shipping Address</h3>
					</div>

					<div class="panel-body">
						<div class="form-group">
							<input class="form-control" type="text" placeholder="Full Name"
								name="">
						</div>

						<div class="form-group">
							<input class="form-control" type="text"
								placeholder="Street Address" name="">
						</div>
						<div class="form-group">
							<input class="form-control" type="text" placeholder="City"
								name="">
						</div>
						<div class="form-group">
							<input class="form-control" type="text" placeholder="State"
								name="">
						</div>

						<div class="form-group">
							<input class="form-control" type="text" placeholder="Country"
								name="">
						</div>

					</div>

				</div>
			</div>

			<div class="col-lg-6">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Billing Address</h3>
					</div>

					<div class="panel-body">
						<div class="form-group">
							<input class="form-control" type="text" placeholder="Full Name"
								name="">
						</div>

						<div class="form-group">
							<input class="form-control" type="text"
								placeholder="Street Address" name="">
						</div>
						<div class="form-group">
							<input class="form-control" type="text" placeholder="City"
								name="">
						</div>
						<div class="form-group">
							<input class="form-control" type="text" placeholder="State"
								name="">
						</div>

						<div class="form-group">
							<input class="form-control" type="text" placeholder="Country"
								name="">
						</div>

					</div>

				</div>
			</div>
		</div>

		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<h3 id="paymentHead" class="panel-title pull-left">Payment
							Details</h3>
						<div class="">
							<img class="img-responsive pull-right"
								src="http://i76.imgup.net/accepted_c22e0.png">
						</div>
					</div>
				</div>

				<div class="panel-body">
					<div class="form-group">
						<input class="form-control" type="text"
							placeholder="Your Name On The Card" name="">
					</div>

					<div class="form-group">
						<input class="form-control" type="number"
							placeholder="Card Number" name="cardNumber" required>
					</div>

				</div>

			</div>

		</div>

	</div>

</body>
</html>