<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>webstore</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/js/webstore.js' />"></script>
</head>
<body>
	<div id="wrapper">
		<div class="header_div">
			<div class="header_text">
				<h1 class="gtitle">Cstech WebStore</h1>
			</div>
			<div class="menu">
				<div class="shoppingcardv">
				    <div class="backtoshopping">
				       <a class="link_button" href="<c:url value="products"/>">back shopping</a>
				    </div>
			<!--  		<div class="shopping_logout">
						<a class="link_button" href="/LogoutServlet">logout</a>
					</div>-->
				</div>
			</div>
		</div>
		 <h2 class="gtitle1">Your Shopping Cart</h2>
		<div class="shopping-cart">
		<!-- shopping cart view header -->
			 <div class="item">
					<div class="buttons">
						<span class="delete-btn"></span> <span class="like-btn"></span>
					</div>
					
					<div class="image">
						<span>Product Name</span>
					</div>

					<div class="description">
						<span>Product description</span>
					</div>

					<div class="quantity">
						<span>Product Quantity</span>
					</div>

					<div class="total-price">Product price</div>
               </div>
			<!-- shopping cart view content --> 
			<c:forEach var="cartItem" items="${cart.getItems()}">
				<div class="item">
					<div class="buttons">
						<span class="delete-btn"></span> <span class="like-btn"></span>
					</div>

					<div class="image">
						<img class="cart_image" src="images/${cartItem.product.image}.png" alt="" />
					</div>

					<div class="description">
						<span>Common Projects</span> <span>Bball High</span> <span>White</span>
					</div>

					<div class="quantity">
						<button class="btn1 plus-btn" data-iprice="${cartItem.product.price}" data-id="${cartItem.product.id}" data-btn='plus' type="button" name="button">
							<img src="images/plus.png" alt="" />
						</button>
						<input type="text" name="name" value="${cartItem.quantity}">
						<button class="btn1 minus-btn" data-iprice="${cartItem.product.price}" data-id="${cartItem.product.id}" data-btn='minus' type="button" name="button">
							<img src="images/minus.png" alt="" />
						</button>
					</div>

					<div class="total-price"><span>\$</span><span id="itemprice_${cartItem.product.id}">${cartItem.getTotalPrice()}</span></div>
					<div class="total-price"><span id="error_message${cartItem.product.id}" class="error_msg"></span></div>
				</div>
			</c:forEach>
				<!-- shopping cart view footer -->		
           
			 <div class="item">
					<div class="buttons">
						<span class="delete-btn"></span> <span class="like-btn"></span>
					</div>
					
					<div class="image">
						<span></span>
					</div>

					<div class="description">
						<span></span>
					</div>

					<div class="quantity">
						<span>Total price</span>
					</div>
					<c:url  var="checkout_url" value="/checkout">
						<c:param name="action" value="CHECKOUT"></c:param>
					</c:url>
					<div class="total-price"><span>\$</span><span id="totalamount"> ${cart.getTotalAmount()}</span>
					    <a id="checkoutbutton" class="link_button_checkout" href="${checkout_url}">Checkout</a>
					</div>
               </div>
		</div>
	</div>

</body>
</html>