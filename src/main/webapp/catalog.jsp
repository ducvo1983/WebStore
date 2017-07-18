<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@taglib prefix="pv" uri="/WEB-INF/tlds/productview.tld" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>webstore</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
		     <label><input class="sizeclass" disabled="disabled" type="text" value="0" name="i_number"/>Items</label>
		     </div>
		      <div class="shopping_checkout">
		           <a class="link_button" href="/checkoutServlet">Checkout</a>
		     </div>
		  </div>
		  </div>
		</div>
		<div class="content_div">
			<c:forEach var="product" items="${products}">
				<pv:productview product="${product}"/>
			</c:forEach>
		</div>
	</div>

</body>
</html>