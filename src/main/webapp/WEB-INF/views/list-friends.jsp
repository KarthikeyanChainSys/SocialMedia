<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friend List</title>
</head>
<body>
<div id="table root"></div>
	<table>
		<thead>
			<tr>
				<th>FriendId</th>
				<th>UserId</th>
				<th>RequestStatus</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="friends" items="${allfriend}">
				<tr>
					<td>${friends.friendId}</td>
					<td>${friends.userId}</td>
					<td>${friends.requestStatus}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>