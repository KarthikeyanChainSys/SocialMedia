<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>List User and Friend</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="getuser">
				<div>
					<label for="userId">UserId:</label>
					<div>
						<form:input path="userId" />
					</div>
				</div>
				<div>
					<label for="email">Email:</label>
					<div>
						<form:input path="email" />
					</div>
				</div>
				<div>
					<label for="password">Password:</label>
					<div>
						<form:input path="password" />
					</div>
				</div>
				<div>
					<label for="userName">UserName:</label>
					<div>
						<form:input path="userName" />
					</div>
				</div>
				<div>
					<label for="dob">DOB:</label>
					<div>
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
					<label for="joiningDate">JoiningDate:</label>
					<div>
						<form:input path="joiningDate" />
					</div>
				</div>
				<div>
					<label for="gender">Gender:</label>
					<div>
						<form:input path="gender" />
					</div>
				</div>
			</form:form>
		</div>
		<div id="friendlist"></div>
		<table border="2" width="100%" cellpadding="2">
		<caption>List User Friends</caption>
			<thead>
				<tr>
					<th>FriendId</th>
					<th>UserId</th>
					<th>RequestStatus</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="friends" items="${friendlist}">
					<tr>
						<td>${friends.friendId}</td>
						<td>${friends.userId}</td>
						<td>${friends.requestStatus}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>