<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product list for Admin</title>

<link href="../css/productListForAdmin.css" type="text/css"
	rel="stylesheet">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Product List</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<button id="addProductButton">Add New Product</button>
			<table>
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Product price</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<c:url var="updateLink" value="TODO">
							<!-- This should be sent to the get method -->
							<c:param name="command" value="UPDATE"></c:param>
							<c:param name="productId" value="${product.id }"></c:param>

						</c:url>
						<c:url var="deleteLink" value="TODO">
							<!-- This should be sent to the get method -->
							<c:param name="command" value="DELETE"></c:param>
							<c:param name="productId" value="${product.id }"></c:param>

						</c:url>
						<tr>
							<td>${product.name}</td>
							<td>${product.price}</td>
							<td>
								<a href="${updateLink }">Update</a>
								|
								<a href="${deleteLink }">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>