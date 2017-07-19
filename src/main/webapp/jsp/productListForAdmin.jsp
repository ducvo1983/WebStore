<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product list for Admin</title>

<link href="<c:url value='/css/productListForAdmin.css' />"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/js/product_op.js' />"></script>
</head>

<body>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h1 class="panel-title">Product List</h1>
		</div>

		<div class="panel-body">

			<div id="container">

				<div id="content">

					<!-- <button id="addProductButton">Add New Product</button> -->
					<table id="product_list">
						<thead>
							<tr>
								<th>Product Name</th>
								<th>Product price</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products}" var="product">
								<c:url var="updateLink" value="/product_controller">
									<!-- This should be sent to the get method -->
									<c:param name="command" value="UPDATE"></c:param>
									<c:param name="productId" value="${product.id }"></c:param>

								</c:url>
								<c:url var="deleteLink" value="product_controller">
									<!-- This should be sent to the get method -->
									<c:param name="command" value="DELETE"></c:param>
									<c:param name="productId" value="${product.id }"></c:param>

								</c:url>
								<tr id="product${product.id }">
									<td id="name${product.id }">${product.name}</td>
									<td id="price${product.id }">${product.price}</td>
									<td>
										<button class="btnDisplay" data-id="${product.id }">Display</button>
										<button class="btnDel" data-id="${product.id }">Delete</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>


		<div>
			<jsp:include page="updateProduct.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>