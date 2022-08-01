<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Likes List</title>
</head>
<body>
<div id="table root"></div>
	<table>
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
					<td>${like.postid}</td>
					<td>${like.friendid}</td>
					<td>${like.datetime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>