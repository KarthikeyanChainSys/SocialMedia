<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Comment</title>
<style><%@include file="/WEB-INF/css/comment.css"%></style>
</head>
<div>
		<div class="form">
			<form:form action="add" method="post" enctype="multipart/form-data" modelAttribute="addcomment" name="form">
				<div class="form">
						<form:hidden path="postId" />
						<form:hidden path="friendId" />
					<label for="comments">Comments:</label>
					<div>
						<input name="photo" type='file' placeholder='file' accept='audio/*,video/*,image/*' />
					</div>
					<label for="commentText">CommentText:</label>
					<div>
						<form:textarea path="commentText" name="commentText" class="textarea" placeholder="Comment Text" />
					</div>
					<div>
				<a href="/posts/list2?userId="${comment.friendId}><button class="button">Add</button></a>
					</div>
				</div>
			</form:form>
		</div>
	<div id="table root">
	<table class=".table_size">
		<caption></caption>
		<thead>
			<tr>
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
					<td>${comment.friendId}</td>
					<td>${comment.commentText}</td>
					<td>${comment.comments}</td>
					<td>${comment.date}</td>
					<td>${comment.time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>
			
			
			
			
			
			
					