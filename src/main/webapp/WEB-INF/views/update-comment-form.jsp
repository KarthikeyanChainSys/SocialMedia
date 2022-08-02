<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Comment</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="update" method="post" modelAttribute="updatecomment">
				<div>
					<label for="commentId">CommentId:</label>
					<div>
						<form:input path="commentId" />
					</div>
				</div>
				<div>
					<label for="postId">PostId:</label>
					<div>
						<form:input path="postId" />
					</div>
				</div>
				<div>
					<label for="friendId">FriendId:</label>
					<div>
						<form:input path="friendId" />
					</div>
				</div>
				<div>
					<label for="comments">PostType:</label>
					<div>
						<form:input path="comments" type='file' placeholder='file' accept='audio/*,video/*,image/*' />
					</div>
				</div>
				<div>
					<label for="commentText">CommentText:</label>
					<div>
						<form:input path="commentText" />
					</div>
				</div>
				<div>
					<label for="dates">Dates:</label>
					<div>
						<form:input path="dates" />
					</div>
				</div>
				<div>
					<label for="times">Times:</label>
					<div>
						<form:input path="times" />
					</div>
				</div>
				<div>
					<form:button>Update</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>