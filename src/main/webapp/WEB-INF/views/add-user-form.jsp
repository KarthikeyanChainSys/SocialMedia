<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style><%@include file="/WEB-INF/css/form.css"%></s</style>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<h1 class="form">Create an Account</h1>
	<div id="root" >
		<div id="form">
			<form:form class="form" action="add" method="post" modelAttribute="adduser">
				<div>
					<label class="form" for="userName">UserName:</label>
					<div>
						<form:input class="form" path="userName" placeholder="UserName" />
					</div>
				</div>
				<form:errors path="userName" cssClass="text-danger" />
				<div>
					<label class="form" for="email">Email:</label>
					<div>
						<form:input class="form" path="email" placeholder="Email" />
					</div>
				</div>
				<form:errors path="email" cssClass="text-danger" />
				<div>
					<label class="form" for="pasword">Password:</label>
					<div>
						<form:input class="form" path="pasword" type="password" placeholder="Password" />
					</div>
				</div>
				<form:errors path="pasword" cssClass="text-danger" />
				
				<div>
					<label class="form" for="dob">DOB</label>
					<div>
						<form:input class="form" path="dob" type="date" />
					</div>
				</div>
				<div>
					<label class="form" for="country">Country:</label>
					<div>
						<form:input class="form" path="country" placeholder="Country" />
					</div>
				</div>
				<form:errors path="country" cssClass="text-danger" />
				<div>
					<label class="form" for="joiningDate">JoiningDate:</label>
					<div>
						<form:input class="form" path="joiningDate" type="date" />
					</div>
				</div>
				<div>
					<label class="form" for="gender">Gender:</label>
					<div>
                        <form:radiobutton path="gender" value="Male" required="required"/>Male
                        <form:radiobutton path="gender" value="Female" />Female
                    </div>
				</div>
				<form:errors path="gender" cssClass="text-danger" />
				<div>
					<form:button class="button">Sign up</form:button>
				</div>
				<h2 class="form">Create an account and get lot of new good friends</h2>
			</form:form>
		</div>
	</div>
</body>
</html>