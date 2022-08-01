<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="adduser">
				<div>
					<label for="userid">UserId:</label>
					<div>
						<form:input path="userid" />
					</div>
				</div>
				<div>
					<label for="email">Email:</label>
					<div>
						<form:input path="email" />
					</div>
				</div>
				<div>
					<label for="pasword">Password:</label>
					<div>
						<form:input path="pasword" />
					</div>
				</div>
				<div>
					<label for="username">UserName:</label>
					<div>
						<form:input path="username" />
					</div>
				</div>
				<div>
					<label for="dob">DOB:</label>
					<div>
					<%-- <form:input name='date' title="enter your date of birth" path="dob" type="date" /> --%>
						<form:input path="dob" />
					</div>
				</div>
				<div>
					<label for="country">Country:</label>
					<div>
						<form:input path="country" />
					</div>
				</div>
				<div>
					<label for="joiningdate">JoiningDate:</label>
					<div>
						<form:input path="joiningdate" />
					</div>
				</div>
				<div>
					<label for="gender">Gender:</label>
					<div>
						<form:input path="gender" />
					</div>
				</div>
				<div>
					<form:button>Add</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>