<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style><%@include file="/WEB-INF/css/login.css"%>
</style>
<title>Login page</title>
</head>
<body>
	<br>
	<h1>Welcome to FriendsHub</h1>
	<h1>Connect with good friends world around </h1>
	<div id="form">
		<form:form action="userPage" modelAttribute="login" method="post">
			<br>
			<h2>FriendsHub</h2><br><br>
			<label class="form">Email</label><br>
			<form:input class="form" path="email" placeholder="Email" type="email"
			required="true" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" name="email" onblur="emailCheck();"/>
			<br><label class="form">Password</label><br>
			<form:input class="form" path="password" type="password" placeholder="Password" onblur="passwordCheck();"
			pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"/>
			<br>
			<form:button class="form" id="button" target="_self" value="submit">Login</form:button>
			<br>
			<form:button class="signup" id="button" value="submit">
				<a href="/user/adduser" target="_self">SignUp</a>
			</form:button>
		</form:form>
	</div>
	<script>
	var emailCheck = function() {
		 var nameRegex = new RegExp("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		 if(!document.form.email.value.match(nameRegex)){
				if(alert("Email not in the correct format")){ 
					 document.form.email.focus();
			    }
				else
					document.activeElement.blur();
			}
	    else{
	        return false;
	    } 
	   
	}
	 
	 var passwordCheck = function() {
		 var nameRegex = new RegExp("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
		 if(!document.form.password.value.match(nameRegex)){
				if(alert("Password must begin with letter and contain atleast one number and must have atleast 8 characters")){ 
					 document.form.password.focus();
			    }
				else
					document.activeElement.blur();
			}
	    else{
	        return false;
	    } 
	 }
	 </script>
</body>
</html>
