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
	<table>
		<thead>
			<tr>
				<th>UserId</th>
				<th>Email</th>
				<th>Password</th>
				<th>Username</th>
				<th>DOB</th>
				<th>Country</th>
				<th>JoiningDate</th>
				<th>Gender</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="users" items="${alluser}">
				<tr>
					<td>${users.userid}</td>
					<td>${users.email}</td>
					<td>${users.pasword}</td>
					<td>${users.username}</td>
					<td>${users.dob}</td>
					<td>${users.country}</td>
					<td>${users.joiningdate}</td>
					<td>${users.gender}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>