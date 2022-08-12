<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Find Comment ID</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="findcommentbyid">
				<div>
					<label for="commentId">CommentId:</label>
					<div>
						<form:input path="commentId" readonly="true" />
					</div>
				</div>
				<div>
					<label for="postId">PostId:</label>
					<div>
						<form:input path="postId" readonly="true" />
					</div>
				</div>
				<div>
					<label for="friendId">FriendId:</label>
					<div>
						<form:input path="friendId" readonly="true" />
					</div>
				</div>
				<div>
					<label for="comments">PostType:</label>
					<div>
						<form:input path="comments" type='file' placeholder='file' accept='audio/*,video/*,image/*' readonly="true" />
					</div>
				</div>
				<div>
					<label for="commentText">CommentText:</label>
					<div>
						<form:input path="commentText" readonly="true" />
					</div>
				</div>
				<div>
					<label for="dates">Dates:</label>
					<div>
						<form:input path="dates" readonly="true" />
					</div>
				</div>
				<div>
					<label for="times">Times:</label>
					<div>
						<form:input path="times" readonly="true" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>