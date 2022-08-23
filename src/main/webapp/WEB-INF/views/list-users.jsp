<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>User List</title>
<style><%@include file="/WEB-INF/css/table.css"%></style>
</head>
<body>
<button class="button1" onclick="history.back()">Go Back</button>
<div id="table root"></div>
	<table>
		<caption></caption>
		<thead>
			<tr>
				<th>Profile</th>
				<th>UserId</th>
				<th>Email</th>
				<th>Password</th>
				<th>UserName</th>
				<th>DateOfBirth</th>
				<th>Country</th>
				<th>JoiningDate</th>
				<th>Gender</th>
				<th>Requests</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="users" items="${alluser}">
				<tr>
					<td>$(users.profile)<img width="50" height="50" src="getImage?id=${users.userId}" alt="image"></td>
					<td>${users.userId}</td>
					<td>${users.email}</td>
					<td>${users.password}</td>
					<td>${users.userName}</td>
					<td>${users.dob}</td>
					<td>${users.country}</td>
					<td>${users.joiningDate}</td>
					<td>${users.gender}</td>
					<td><a href="/friend/addfriend?friendId=${users.userId}&userId=${userId}"><button class="button1">request</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>