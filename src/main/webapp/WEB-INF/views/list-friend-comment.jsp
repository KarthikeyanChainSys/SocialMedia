<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>List Friend and Comment</title>
<style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="add" method="post"
				modelAttribute="getfriend">
				<div>
					<label for="friendId">FriendId:</label>
					<div>
						<form:input path="friendId" />
					</div>
				</div>
				<div>
					<label for="userId">UserId:</label>
					<div>
						<form:input path="userId" />
					</div>
				</div>
				<div>
					<label for="requestStatus">RequestStatus:</label>
					<div>
						<form:input path="requestStatus" />
					</div>
				</div>
			</form:form>
		</div>
		<div id="table root"></div>
		<table class=".table_size">
			<caption>Friend Comment table</caption>
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
				<c:forEach var="comment" items="${commentlist}">
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
	</div>
</body>
</html>