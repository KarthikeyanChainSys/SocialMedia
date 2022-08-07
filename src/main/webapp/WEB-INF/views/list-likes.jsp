<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Likes List</title>
</head>
<body>
<div id="table root"></div>
	<table border="2" width="100%" cellpadding="2">
		<thead>
			<tr>
				<th>PostId</th>
				<th>FriendId</th>
				<th>DateTime</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="like" items="${alllike}">
				<tr>
					<td>${like.postId}</td>
					<td>${like.friendId}</td>
					<td>${like.dateTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>