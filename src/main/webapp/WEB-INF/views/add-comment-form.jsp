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
<style type="text/css">
.text-danger {
    color: #e80c4d;
    font-size: 0.9em;
}
</style>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="add" method="post" enctype="multipart/form-data" modelAttribute="addcomment" name="form">
				<div>
					<label for="postId">PostId:</label>
					<div>
						<form:input path="postId" name="postId" placeholder="Post Id" />
					</div>
				</div>
				<div>
					<label for="friendId">FriendId:</label>
					<div>
						<form:input path="friendId" name="friendId" placeholder="Friend Id" />
					</div>
				</div>
				<div>
					<label for="comments">Comment:</label>
					<div>
						<input name="photo" type='file' placeholder='file' accept='audio/*,video/*,image/*' />
					</div>
				</div>
				<div>
					<label for="commentText">CommentText:</label>
					<div>
						<form:input path="commentText" name="commentText" placeholder="Comment Text" />
					</div>
				</div>
				<form:errors path="commentText" cssClass="text-danger" />
				<div>
					<form:button>Add</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<div id="table root"></div>
	<table border="2" width="100%" cellpadding="2">
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