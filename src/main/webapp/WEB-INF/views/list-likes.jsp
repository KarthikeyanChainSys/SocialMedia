<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Likes List</title>
<style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
<div id="table root"></div>
	<table class=".table_size">
		<caption>List Likes</caption>
		<thead>
			<tr>
				<th>LikeId</th>
				<th>PostId</th>
				<th>FriendId</th>
				<th>DateTime</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="like" items="${alllike}">
				<tr>
					<td>${like.likeId}</td>
					<td>${like.postId}</td>
					<td>${like.friendId}</td>
					<td>${like.dateTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>