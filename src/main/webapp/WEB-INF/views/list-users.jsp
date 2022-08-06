<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
<div id="table root"></div>
	<table border="2" width="100%" cellpadding="2">
		<thead>
			<tr>
				<th>UserId</th>
				<th>Email</th>
				<th>Password</th>
				<th>UserName</th>
				<th>DOB</th>
				<th>Country</th>
				<th>JoiningDate</th>
				<th>Gender</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="users" items="${alluser}">
				<tr>
					<td>${users.userId}</td>
					<td>${users.email}</td>
					<td>${users.pasword}</td>
					<td>${users.userName}</td>
					<td>${users.dob}</td>
					<td>${users.country}</td>
					<td>${users.joiningDate}</td>
					<td>${users.gender}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>