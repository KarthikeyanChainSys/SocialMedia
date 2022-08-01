<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Post</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="addpost">
				<div>
					<label for="postId">PostId:</label>
					<div>
						<form:input path="postId" />
					</div>
				</div>
				<div>
					<label for="userId">UserId:</label>
					<div>
						<form:input path="userId" />
					</div>
				</div>
				<div>
					<label for="postType">PostType:</label>
					<div>
						<form:input path="postType" type='file' placeholder='file' accept='audio/*,video/*,image/*' />
					</div>
				</div>
				<div>
					<label for="mediaLocation">MediaLocation:</label>
					<div>
						<form:input path="mediaLocation" />
					</div>
				</div>
				<div>
					<label for="visibility">Visibility:</label>
					<div>
						<form:input path="visibility" />
					</div>
				</div>
				<div>
					<label for="likeCount">LikeCount:</label>
					<div>
						<form:input path="likeCount" />
					</div>
				</div>
				<div>
					<form:button>Add</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>