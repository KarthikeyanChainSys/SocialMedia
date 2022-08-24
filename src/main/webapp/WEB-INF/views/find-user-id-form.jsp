<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Find User Id</title>
<style><%@ include file="/WEB-INF/css/about.css"%></s</style>
</head>
<body>
<button class="button"
        onclick="history.back()">Go Back</button>
<div id="root">
		<div class="container">
			<form:form action="" method="get" modelAttribute="finduserbyid">
				<div class="form">
					<div>
						<form:input path="userId" readonly="true" type="hidden"/>
					</div>
					<label for="email">Email:</label>
					<div>
						<form:input path="email" readonly="true"/>
					</div>
					<label for="password">Password:</label>
					<div>
						<form:input path="password" readonly="true"/>
					</div>
					<label for="userName">UserName:</label>
					<div>
						<form:input path="userName" readonly="true"/>
					</div>
					<label for="dob">DOB:</label>
					<div>
						<form:input path="dob" readonly="true"/>
					</div>
					<label for="country">Country:</label>
					<div>
						<form:input path="country" readonly="true"/>
					</div>
					<label for="joiningDate">JoiningDate:</label>
					<div>
						<form:input path="joiningDate" readonly="true"/>
					</div>
					<label for="gender">Gender:</label>
					<div>
						<form:input path="gender" readonly="true"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>