<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<div id="header">
		<form:form action="post" style="text-align: center;">
			<br>
			<br>Email<br>
			<form:input path="email" placeholder="Email" />
			<br> Password<br>
			<form:input path="pasword" placeholder="Password" />
			<br>
			<div>
				<form:button>Login</form:button>
				<br>
			</div>
			<div>
				<form:button a href="/user/adduser">SignUp</form:button>
			</div>
		</form:form>
	</div>
</body>
</html>