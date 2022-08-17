<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Comment List</title>
<style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
<div id="table root"></div>
	<table class=".table_size">
		<caption>Comment table</caption>
		<thead>
			<tr>
				<th>CommentId</th>
				<th>PostId</th>
				<th>FriendId</th>
				<th>commentText</th>
				<th>comments</th>
				<th>Date</th>
				<th>Time</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="comment" items="${allcomment}">
				<tr>
					<td>${comment.commentId}</td>
					<td>${comment.postId}</td>
					<td>${comment.friendId}</td>
					<td>${comment.commentText}</td>
					<td>${comment.comments}
					<img width="100" height="100" src="getimage?id=${comment.commentId}" alt="image"></td>
					<td>${comment.date}</td>
					<td>${comment.time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>