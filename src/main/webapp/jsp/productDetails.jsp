<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="mainHeads.jsp"></jsp:include>
<link href="<c:url  value='/css/productDetails.css'/>" type="text/css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

	<div id="productDetailsContainer">
		<div class="container">
			<div class="row">
				<div class="col-lg-5">
					<!-- This is for the image -->
					<div>
						<img class="productImage" alt=""
							src="<c:url  value='/images/gshirt1.png'/>">
					</div>

				</div>
				<div class="col-lg-7">
					<!-- This for details -->
					<h1>Product Name: </h1>
					<hr>
					<h1>$ USD Product Price</h1>
					<hr>
					<h2>Quantity</h2>
					<hr>
					<div class="row">
						<div class=" col-lg-6">
							<button class="btn btn-success btn-default">Add To Cart</button>
						</div>
						<div class=" col-lg-6">
							<div class="btn-group pull-right">
								<button class="btn btn-white btn-default">
									<i class="fa fa-star"></i> Add to wishlist
								</button>
								<button class="btn btn-white btn-default">
									<i class="fa fa-envelope"></i> Contact Seller
								</button>
							</div>
						</div>
					</div>

					<hr>
					<div>
						<h3>Full Description</h3>
						<p>Write the description of the product here. </p>
					</div>
				</div>
			</div>
		</div>
	</div>





</body>
</html>