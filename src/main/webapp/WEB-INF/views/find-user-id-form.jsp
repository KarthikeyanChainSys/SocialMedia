<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find User Id</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="" method="get" modelAttribute="finduserbyid">
				<div>
					<label for="userid">UserId:</label>
					<div>
						<form:input path="userid" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="email">Email:</label>
					<div>
						<form:input path="email" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="pasword">Password:</label>
					<div>
						<form:input path="pasword" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="username">Username:</label>
					<div>
						<form:input path="username" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="dob">DOB:</label>
					<div>
						<form:input path="dob" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="country">Country:</label>
					<div>
						<form:input path="country" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="joiningdate">JoiningDate:</label>
					<div>
						<form:input path="joiningdate" readonly="true"/>
					</div>
				</div>
				<div>
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