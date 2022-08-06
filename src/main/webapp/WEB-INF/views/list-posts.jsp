<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post List</title>
</head>
<body>
<div id="table root"></div>
	<table border="2" width="100%" cellpadding="2">
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>