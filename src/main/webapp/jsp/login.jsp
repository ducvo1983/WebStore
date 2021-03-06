<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
	<jsp:include page="mainHeads.jsp"></jsp:include>
	<link href="<c:url value='/css/loginSignUp.css'/>" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="loginSingUpContainer">
		<div class="container well">
			<legend> Sign In! </legend>
			<form action="<c:url value='/login' />" method="post">
				<div class="form-group">
					<label for="username">Username:</label> 
					<input type="text" class="form-control" id="username" placeholder="Enter email" name="username"
						value="${cookie.username.value}" pattern="(?=\S)(^[a-zA-Z0-9_]+$)" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> 
					<input class="form-control" type="password" id="password" placeholder="Enter password" name="password" pattern="((?=.*[A-Z])(?=.*[a-z])(?=.*\d).{6,})"
						required>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
				<div  class="checkbox">
					<label>
					<input type="checkbox" name="rememberMeChk"
						<c:if test="${not empty cookie.username.value}">checked</c:if> /> Remember Me
					</label>
				</div>
				<div>
					<a href="<c:url value='/jsp/signUp.jsp' />">Sign Up</a>
				</div>
				<span style="color:red;text-align:center;">${error_login_msg}</span>
			</form>
		</div>
	</div>
</body>
</html>