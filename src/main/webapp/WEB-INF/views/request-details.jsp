<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Request Details</title>
<style><%@include file="/WEB-INF/css/requestdetails.css"%></style>
</head>
<body>
	<button class="button1"
        onclick="history.back()">Go Back</button>
<form>
<div >
	<table>
		<caption></caption>
		<thead>
			<tr>
				<th>FriendId</th>
				<th>UserId</th>
				<th>RequestStatus</th>
				<th>Reject</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="friends" items="${requestLists}">
				<tr>
					<td>${friends.friendId}</td>
					<td>${friends.userId}</td>
					<td>${friends.requestStatus}</td>
					<td><a href="/friend/deletefriend?id=${friends.friendId}&userId=${friends.userId}">
						<button class="button" type="button">UnRequest </button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</form>
</body>
</html>