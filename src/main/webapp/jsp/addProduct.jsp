<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
	<jsp:include page="mainHeads.jsp"></jsp:include>
	<link href="../css/addUpdateProduct.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="loginSingUpContainer">
		<div class="container well">
			<legend> Add New Product! </legend>
			<form action="" method="post">
				<div class="form-group">
					<label for="productName">Product Name:</label> 
					<input type="text" class="form-control" id="productName" placeholder="Product Name" name="productName" required>
				</div>
				<div class="form-group">
					<label for="productPrice">Product Price:</label> 
					<input type="number" class="form-control" id="productPrice" placeholder="Product Price" name="productPrice" required>
				</div>
				<div class="form-group">
					<label for="productQuantity">Product Price:</label> 
					<input type="number" class="form-control" id="productQuantity" placeholder="Product Quantity" name="productQuantity" required>
				</div>
				<div class="form-group">
					<label for="fullDescription">Full Description:</label> 
					<textarea class="form-control" rows="7" id="fullDescription" placeholder="Full Description"
					name="fullDescription"></textarea>
				</div>
				<div class="form-group">
					<label for="shortDescription">Full Description:</label> 
					<textarea class="form-control" rows="3" id="shortDescription" placeholder="Short Description"
					name="shortDescription"></textarea>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Add New Product</button>
			</form>
		</div>
	</div>
</body>
</html>