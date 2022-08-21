<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Friend List</title>
<style><%@include file="/WEB-INF/css/requestdetails.css"%></style>
</head>
<body>
<button class="button1"
        onclick="history.back()">Go Back</button>
<form>
<div>
	<table>
		<caption></caption>
		<thead>
			<tr>
				<th>UserId</th>
				<th>FriendId</th>
				<th>RequestStatus</th>
				<th>Accept</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="friends" items="${requestList}">
				<tr>
					<td>${friends.friendId}</td>
					<td>${friends.userId}</td>
					<td>${friends.requestStatus}</td>
					<td><a href="/friend/updatefriend?id=${friends.friendId}&userId=${friends.userId}">Accept</a></td>
					<td><a href="/friend/deletefriend?id=${friends.friendId}&userId=${friends.userId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</form>
</body>
</html>