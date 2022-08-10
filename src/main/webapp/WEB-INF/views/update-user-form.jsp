<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form style="text-align:center" action="update" method="post" modelAttribute="updateuser">
				<div>
					<div>
						<form:hidden path="userId" />
					</div>
				</div>
				
				<div>
					<label for="email">Email:</label>
					<div>
						<form:input path="email" placeholder="Email" />
					</div>
				</div>
				<div>
					<label for="pasword">Password:</label>
					<div>
						<form:input path="pasword" placeholder="Password" />
					</div>
				</div><div>
					<label for="userName">UserName:</label>
					<div>
						<form:input path="userName" placeholder="UserName" />
					</div>
				</div>
				<form:errors path="userName" cssClass="text-danger" />
				<br>
				<div>
					<label for="dob">DOB</label>
					<div>
						<form:input path="dob" type="date" />
					</div>
				</div>
				<br>
				<div>
					<label for="country">Country:</label>
					<div>
						<form:input path="country" placeholder="Country" />
					</div>
				</div>
				<form:errors path="country" cssClass="text-danger" />
				<br>
				<div>
					<label for="joiningDate">JoiningDate:</label>
					<div>
						<form:input path="joiningDate" type="date" />
					</div>
				</div>
				<br>
				<div>
					<label for="gender">Gender:</label>
					<div>
						<form:input path="gender" placeholder="Gender" />
					</div>
				</div>
				<form:errors path="gender" cssClass="text-danger" />
				<br>
				<div>
					<form:button>Update</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>