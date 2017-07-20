<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="mainHeads.jsp"></jsp:include>
<link href="<c:url  value='/css/orderList.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>

	<div id="orderListContainer">
		<div class="container">
			<legend> Order List </legend>
			
			<div>
				<div>
					<c:forEach items="${orders}" var = "order">
							<div>
								<h1>"${order.id }"</h1>
								<h2>"${order.orderDate }"</h2>
							</div>
						<c:forEach items="${order.items}" var="cartItem">
							<div>
								<p> "${cartItem.quantity}" </p>
								<p> "${cartItem.product.quantity}" </p>
								
							</div>
							<hr>
						</c:forEach>
						<hr>
						<hr>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>
</body>
</html>