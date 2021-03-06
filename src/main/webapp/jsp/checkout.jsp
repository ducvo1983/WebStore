<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<jsp:include page="mainHeads.jsp"></jsp:include>
<link href="<c:url value='/css/checkout.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<h2 class="gtitle1">Your Order Item</h2>
		<div class="shopping-cart_order">
			<!-- shopping cart view content -->
			<c:forEach var="cartItem" items="${cart.getItems()}">

				<div class="item">
					<div class="buttons">
						<span class="delete-btn"></span> <span class="like-btn"></span>
					</div>

					<div class="image">
						<img class="cart_image" src="images/${cartItem.product.image}.png"
							alt="" />
					</div>

					<div class="description">
						<span>${cartItem.product.shortDescription}</span>
					</div>

					<div class="quantity">

						<input type="text" name="name" value="${cartItem.quantity}">

					</div>

					<div class="total-price">
						<span>\$</span><span id="itemprice_${cartItem.product.id}">${cartItem.getTotalPrice()}</span>
					</div>
				</div>
			</c:forEach>

		</div>
		<div class='order_price'>
		<span>Tax: 2%</span>
		</div>
		<div  class='order_price'>
			<span>Total cost : ${cart.getTotalAmount()}</span>
		</div>
		
		<c:url var="order_action" value="/order">
			<c:param name="command" value="ORDER"></c:param>
		</c:url>
		<form action="${order_action}" method="post">
			<div class="row">

				<div class="col-lg-6 block1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Shipping Address</h3>
						</div>

						<div class="panel-body">
							<div class="form-group">
								<input class="form-control" type="text" placeholder="Full Name"
									name="sfullname">
							</div>

							<div class="form-group">
								<input class="form-control" type="text"
									placeholder="Street Address" name="sstreet">
							</div>
							<div class="form-group">
								<input class="form-control" type="text" placeholder="City"
									name="scity">
							</div>
							<div class="form-group">
								<input class="form-control" type="text" placeholder="State"
									name="sstate">
							</div>

							<div class="form-group">
								<input class="form-control" type="text" placeholder="Country"
									name="scountry">
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
									name="bfullname">
							</div>

							<div class="form-group">
								<input class="form-control" type="text"
									placeholder="Street Address" name="bstreet">
							</div>
							<div class="form-group">
								<input class="form-control" type="text" placeholder="City"
									name="bcity">
							</div>
							<div class="form-group">
								<input class="form-control" type="text" placeholder="State"
									name="bstate">
							</div>

							<div class="form-group">
								<input class="form-control" type="text" placeholder="Country"
									name="bcountry">
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
								placeholder="Your Name On The Card" name="nameoncard">
						</div>

						<div class="form-group">
							<input class="form-control" type="number"
								placeholder="Card Number" name="cardNumber" required>
						</div>

					</div>

				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Proceed</button>
				<br />
			</div>
		</form>
	</div>

</body>
</html>