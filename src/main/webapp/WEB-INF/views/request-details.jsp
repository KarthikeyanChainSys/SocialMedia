<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Request Details</title>
<style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
<div id="table root"></div>
	<table class=".table_size">
		<caption>List Friends</caption>
		<thead>
			<tr>
				<th>FriendId</th>
				<th>UserId</th>
				<th>RequestStatus</th>
				<th>Reject</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="friends" items="${requestList}">
				<tr>
					<td>${friends.friendId}</td>
					<td>${friends.userId}</td>
					<td>${friends.requestStatus}</td>
					<td><a href="/friend/deletefriend?id=${friends.friendId}&userId=${friends.userId}">UnRequest</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>