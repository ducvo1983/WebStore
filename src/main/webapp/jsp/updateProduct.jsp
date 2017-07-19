<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
	<jsp:include page="mainHeads.jsp"></jsp:include>
	<link href="<c:url value='/css/addUpdateProduct.css'/>" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="loginSingUpContainer">
		<div class="container well">
			<legend> Product Operations! </legend>
			<c:url var="updateAction" value="/product_controller">
				<!-- This should be sent to the get method -->
				<c:param name="command" value="UPDATE_CLICKED"></c:param>
				<c:param name="productId" value="${product.id }"></c:param>
			</c:url>
			<!-- <form action="${updateAction }" method="post"> -->
				<div class="form-group">
					<label for="productName">Product Name:</label> 
					<input type="text" class="form-control" id="productName" placeholder="Product Name" name="productName" value="${product.name }" required>
				</div>
				<div class="form-group">
					<label for="productPrice">Product Price:</label> 
					<input type="number" class="form-control" id="productPrice" placeholder="Product Price" name="productPrice" value="${product.price }" required>
				</div>
				<div class="form-group">
					<label for="productImage">Product Image:</label> 
					<input type="text" class="form-control" id="productImage" placeholder="Product Image" name="productImage" value="${product.image }" required>
				</div>
				<div class="form-group">
					<label for="productQuantity">Product Quantity:</label> 
					<input type="number" class="form-control" id="productQuantity" placeholder="Product Quantity" name="productQuantity" value="${product.quantity }" required>
				</div>
				<div class="form-group">
					<label for="fullDescription">Full Description:</label> 
					<textarea class="form-control" rows="7" id="fullDescription" placeholder="Full Description"
					name="fullDescription">${product.fullDescription }</textarea>
				</div>
				<div class="form-group">
					<label for="shortDescription">Short Description:</label> 
					<textarea class="form-control" rows="3" id="shortDescription" placeholder="Short Description"
					name="shortDescription">${product.shortDescription }</textarea>
				</div>
				<input type="hidden" id="productId" name="productId" value="${product.id }" />
				<div class="form-inline">
					<button class="btn btn-lg btn-primary btn-block" type="submit" id="btnUpdate">Update</button>
					<button class="btn btn-lg btn-primary btn-block" type="submit" id="btnAdd">Add New</button>
				</div>
			<!-- </form>  -->
		</div>
	</div>
</body>
</html>