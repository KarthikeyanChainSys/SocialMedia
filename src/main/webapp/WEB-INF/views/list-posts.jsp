<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Post List</title>
<style>
table, th, td {
  border:1px solid black;
}
</style>
</head>
<body>
<div id="table root"></div>
	<table style="width:100%">
		<thead>
			<tr>
				<th>PostId</th>
				<th>UserId</th>
				<th>PostType</th>
				<th>MediaLocation</th>
				<th>Visibility</th>
				<th>Date</th>
				<th>Time</th>
				<th>LikeCount</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${allpost}">
				<tr>
					<td>${post.postId}</td>
					<td>${post.userId}</td>
					<td>${post.postType}</td>
					<td>${post.mediaLocation}</td>
					<td>${post.visibility}</td>
					<td>${post.dates}</td>
					<td>${post.times}</td>
					<td>${post.likeCount}</td>
					<td><a href="deletepost?id=${post.postId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>