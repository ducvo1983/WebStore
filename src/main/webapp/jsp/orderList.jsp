<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="mainHeads.jsp"></jsp:include>
<link href="<c:url  value='/css/orderList2.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<c:forEach items="${orders}" var="order">

			<div class="row">
				<div class="col-xs-12">
					<div class="invoice-title">
						<h2>
							Order Id: <span style="color: blue; font-weight: bold;">${order.orderId }</span>
						</h2>
					</div>
					<hr>
					<div class="row">
						<div class="col-xs-6">
							<address>
								<strong>Shipped to:</strong><br> ${order.shpAdress.fullName }<br>
								${order.shpAdress.street }<br> ${order.shpAdress.city }<br>
								${order.shpAdress.state }<br>${order.shpAdress.country }
							</address>
						</div>
						<div class="col-xs-6 text-right">
							<address>
								<strong>Billing:</strong><br> ${order.billAddress.fullName }<br>
								${order.billAddress.street }<br> ${order.billAddress.city }<br>
								${order.billAddress.state }<br>${order.billAddress.country }
							</address>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6">
							<address>
								<strong>Payment Method:</strong><br> Visa ending **** 4242<br>
								mohammed.ahmed.ps@gmail.com
							</address>
						</div>
						<div class="col-xs-6 text-right">
							<address>
								<strong>Order Date:</strong><br> ${order.orderDate }<br>
								<br>
							</address>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<strong>Order summary</strong>
							</h3>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-condensed">
									<thead>
										<tr>
											<td><strong>Item</strong></td>
											<td class="text-center"><strong>Price</strong></td>
											<td class="text-center"><strong>Quantity</strong></td>
											<td class="text-right"><strong>Totals</strong></td>
										</tr>
									</thead>
									<tbody>
										<!-- foreach ($order->lineItems as $line) or some such thing here -->
										<c:forEach items="${order.items}" var="cartItem">
											<tr>
												<td>cartItem.product.name</td>
												<td class="text-center">${cartItem.product.price}</td>
												<td class="text-center">${cartItem.quantity}</td>
												<td class="text-right">$10.99</td>
											</tr>
										</c:forEach>

										<tr>
											<td class="thick-line"></td>
											<td class="thick-line"></td>
											<td class="thick-line text-center"><strong>Subtotal</strong></td>
											<td class="thick-line text-right">$ ${order.amount }</td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
		</c:forEach>
	</div>

</body>
</html>