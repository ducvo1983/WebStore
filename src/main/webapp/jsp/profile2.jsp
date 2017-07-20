<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="mainHeads.jsp"></jsp:include>

<link href="<c:url  value='/css/profile.css'/>" type="text/css"
	rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container">

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="myProfile" class="active"><a href="#">Profile</a></li>
				<li id="myOrders" ><a href="#">My Orders</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>


	<div id="dataContainer">
	
		<div id="loginSingUpContainer">
		<div id="profileContainer" class="container well">
			<legend> My Profile Information </legend>
			<form action="update" method="post">
				<div class="form-group">
					<label for="firstName">First Name:</label> <input type="text"
						class="form-control" id="firstName" placeholder="First Name"
						name="firstName" required value="${account.firstName }">
				</div>
				<div class="form-group">
					<label for="lastName">Last Name:</label> <input type="text"
						class="form-control" id="lastName" placeholder="Last Name"
						name="lastName" required value="${currentUser.lastName }">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="text"
						class="form-control" id="email" placeholder="Enter email"
						name="email"
						pattern="^[a-zA-Z0-9_\-]+@(([a-zA-Z_\-])+\.)+[a-zA-Z]{2,4}$"
						required value="${currentUser.email }">
				</div>
				<div class="form-group">
					<label for="phone">Phone number:</label> <input type="text"
						class="form-control" id="phoneNo" placeholder="Enter phone number"
						name="phoneNo" pattern="^((\d){10})$"
						value="${currentUser.phoneNumber }">
				</div>
				<div class="form-group">
					<label for="username">User name:</label> <input type="text"
						class="form-control" id="username" placeholder="Enter user name"
						name="username" pattern="(?=\S)(^[a-zA-Z0-9_]+$)" required
						value="${currentUser.userName }">
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input class="form-control"
						type="password" id="password" placeholder="Enter password"
						pattern="((?=.*[A-Z])(?=.*[a-z])(?=.*\d).{6,})" name="password">
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>