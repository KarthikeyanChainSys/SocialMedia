<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="mystyle.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Login page</title>
</head>
<body>
	<div id="header">
		<form:form action="userPage" modelAttribute="login" method="post">
			<br>
			<div class="f-container">
				<img src="/static/images/Facebook-Lite.jpg" alt="Facebook">
			</div>
			<br>
			<br>Email<br>
			<form:input path="email" placeholder="Email" />
			<br> Password<br>
			<form:input path="password" placeholder="Password" />
			<br>
			<br>
			<form:button id="button" onclick="myFunction()">
			Login
			</form:button>
			<p id="demo"></p>
			<br>
			<br>
			<form:button id="button">
				<a href="/user/adduser" target="_self">SignUp</a>
			</form:button>
		</form:form>
	</div>
	<div>${result}</div>
</body>
</html>
