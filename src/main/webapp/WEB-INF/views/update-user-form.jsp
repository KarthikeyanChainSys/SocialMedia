<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Update User</title>
<style type="text/css">
.text-danger {
    color: #e80c4d;
    font-size: 0.9em;
}
</style>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="update" method="post" modelAttribute="updateuser">
				<div>
					<label for="userId">UserId:</label>
					<div>
						<form:input path="userId" placeholder="User Id" />
					</div>
				</div>
				<div>
					<label for="email">Email:</label>
					<div>
						<form:input path="email" placeholder="Email" />
					</div>
				</div>
				<form:errors path="email" cssClass="text-danger" />
				<div>
					<label for="pasword">Password:</label>
					<div>
						<form:input path="pasword" placeholder="Password" />
					</div>
				</div>
				<form:errors path="pasword" cssClass="text-danger" />
				<div>
					<label for="userName">UserName:</label>
					<div>
						<form:input path="userName" placeholder="UserName" />
					</div>
				</div>
				<form:errors path="userName" cssClass="text-danger" />
				<div>
					<label for="dob">DOB</label>
					<div>
						<form:input path="dob" type="date" />
					</div>
				</div>
				<div>
					<label for="country">Country:</label>
					<div>
						<form:input path="country" placeholder="Country" />
					</div>
				</div>
				<form:errors path="country" cssClass="text-danger" />
				<div>
					<label for="joiningDate">JoiningDate:</label>
					<div>
						<form:input path="joiningDate" type="date" />
					</div>
				</div>
				<div>
					<label for="gender">Gender:</label>
					<div>
						<form:input path="gender" placeholder="Gender" />
					</div>
				</div>
				<form:errors path="gender" cssClass="text-danger" />
				<div>
					<form:button>Update</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>