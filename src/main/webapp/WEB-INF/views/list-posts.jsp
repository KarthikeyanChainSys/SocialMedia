<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Post List</title>
<style>
table, th, td {
	border: 1px solid black;
}

.like_btn {
	padding: 10px 15px;
	background: #0080ff;
	font-size: 18px;
	font-family: "Open Sans", sans-serif;
	border: none;
	outline: none;
	color: #e8efff;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<script type="text/javascript">
	function like1() {
		let likebutton = document.querySelector('#likebutton');
		let input = document.querySelector('#input');
		likebutton.addEventListener('click', () => {
			input.value = parseInt(input.value) + 1;
			input.style.color = "#12ff00";
		})
	}
	</script>
	<div id="table root"></div>
	<table style="width: 100%">
		<caption>List of Posts</caption>
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
				<th>Like</th>
				<th>Comment</th>
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
					<td><button class="like_btn" onclick="like1();">
							<span id="icon"></span> <span id="count">0</span>Like
						</button></td>
					<td><button>comment</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>