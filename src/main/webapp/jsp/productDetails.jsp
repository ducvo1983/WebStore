<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/js/webstore.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value ='/css/style.css'/>" />
<jsp:include page="mainHeads.jsp"></jsp:include>
<link href="<c:url  value='/css/productDetails.css'/>" type="text/css" rel="stylesheet">

	
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
<div id="wrapper">
		<div class="header_div">
		<div class="header_text">
		 <h1>Cstech WebStore</h1>
		</div>
		<div class="menu">
		  <div class="shoppingcard">
		    <div class="shopping_cart">
		     <img alt="shopping_cartImage" src="images/shpp.png">
		     </div>
		     <div class="shopping_input">
		     <label><input class="sizeclass"  disabled="disabled" type="text" value="${cart_size}" id="i_number"/>Items</label>
		     </div>
		      <div class="shopping_checkout">
		           <a class="link_button" href="<c:url value ="/cartViewServlet"/>">Checkout</a>
		     </div>
		  </div>
		  </div>
		</div>

	<div id="productDetailsContainer">
		<div class="container">
			<div class="row">
				<div class="col-lg-5">
					<!-- This is for the image -->
					<div>
						<img class="productImage" alt=""
							src="<c:url  value='/images/${product.image}.png'/>">
					</div>

				</div>
				<div class="col-lg-7">
					<!-- This for details -->
					<h2>Product Name:${product.name} </h2>
					<hr>
					<h2>Product Price $:${product.price} </h2>
				     <input type="hidden" value="${product.id}" id="hpid"/>
					 <label>Quantity <input class="sizeclassn" required="required" type="number" value="${cartItemQuantity}" id="pdquantity"/></label>
					<hr>
					<div class="row">
						<div class=" col-lg-6">
							<buttonv id="bpdetail" class="btn btn-success btn-default">Add To Cart</button>
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
						<p>${product.fullDescription} </p>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>