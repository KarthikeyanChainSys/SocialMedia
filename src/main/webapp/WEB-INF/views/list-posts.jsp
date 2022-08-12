<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
<meta charset="ISO-8859-1">
<title>Post List</title>
<style>
table, th, td {
	border: 1px solid black;
}

textarea {
    display: block;
    margin-left: auto;
    margin-right: auto;
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
	$('#foo').click(function() {
	    var button = $(this),
	        commentField = $('<textarea/>');
	        .val(button.data('textContent') || 'This is my comment field\'s text')
	        .keypress(function(e) {
	            if (e.which === 13) {
	                e.preventDefault();
	                button.data('textContent', this.value);
	                $(this).remove();
	            }
	        })
	        .appendTo(document.body);
	});
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
					<td><button class="like_btn" onclick="like()">
							<span id="icon"><em class="far fa-thumbs-up"></em></span> <span
								id="count">0</span>&nbsp;Like
						</button></td>
					<td><button class="button" onclick="foo">comment</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form onclick="e" class="textarea" >
	<textarea rows="5" cols="40" name="text" id="text_id" class="foo" style="resize:vertical"></textarea>
	<input type="submit" value="Submit">
	</form>
</body>
</html>