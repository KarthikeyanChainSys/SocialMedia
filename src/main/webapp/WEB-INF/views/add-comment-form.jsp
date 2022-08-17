<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Add Comment</title>
<style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="add" method="post" enctype="multipart/form-data" modelAttribute="addcomment" name="form">
				<div>
						<form:hidden path="postId" />
				</div>
				<div>
						<form:hidden path="friendId" />
					</div><br>
				<div>
					<label for="comments">Comments:</label>
					<div>
						<input name="photo" type='file' placeholder='file' accept='audio/*,video/*,image/*' />
					</div>
				</div><br>
				<div>
					<label for="commentText">CommentText:</label>
					<div>
						<form:textarea path="commentText" name="commentText" class="textarea" placeholder="Comment Text" />
					</div>
				</div><br>
				<form:errors path="commentText" cssClass="text-danger" />
				<div>
					<form:button>Add</form:button>
				</div>
			</form:form>
		</div>
	</div>
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
					<td>${comment.comments}</td>
					<td>${comment.date}</td>
					<td>${comment.time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>