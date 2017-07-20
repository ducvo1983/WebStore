<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
	<jsp:include page="mainHeads.jsp"></jsp:include>
	
	<link href="<c:url  value='css/loginSignUp.css'/>" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="loginSingUpContainer">
		<div class="container well">
			<legend> Sign Up! </legend>
			<form action="<c:url value='/signup'/>" method="post">
				<div class="form-group">
					<label for="firstName">First Name:</label> 
					<input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName" required>
				</div>
				<div class="form-group">
					<label for="lastName">Last Name:</label> 
					<input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastName" required>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> 
					<input type="text" class="form-control" id="email" placeholder="Enter email" name="email" pattern="^[a-zA-Z0-9_\-]+@(([a-zA-Z_\-])+\.)+[a-zA-Z]{2,4}$" required>
				</div>
				<div class="form-group">
					<label for="phone">Phone number:</label> 
					<input type="text" class="form-control" id="phoneNo" placeholder="Enter phone number" name="phoneNo" pattern="^((\d){10})$">
				</div>
				<div class="form-group">
					<label for="username">User name:</label> 
					<input type="text" class="form-control" id="username" placeholder="Enter user name" name="username" pattern="(?=\S)(^[a-zA-Z0-9_]+$)" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> 
					<input class="form-control" type="password" id="password" placeholder="Enter password" pattern="((?=.*[A-Z])(?=.*[a-z])(?=.*\d).{6,})" name="password" required>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button><br />
				<span style="color:red;text-align:center;'">${error_signup_msg}</span>
			</form>
		</div>
	</div>
</body>
</html>