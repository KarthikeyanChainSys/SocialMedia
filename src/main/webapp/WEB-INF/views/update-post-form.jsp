<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Add Post</title>
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
			<form:form action="update" method="post" modelAttribute="updatepost">
				<div>
					<label for="postId">PostId:</label>
					<div>
						<form:input path="postId" placeholder="Post Id" />
					</div>
				</div>
				<div>
					<label for="userId">UserId:</label>
					<div>
						<form:input path="userId" placeholder="User Id" />
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
						<form:input path="mediaLocation" placeholder="Media Location" />
					</div>
				</div>
				<form:errors path="mediaLocation" cssClass="text-danger" />
				<div>
					<label for="visibility">Visibility:</label>
					<div>
						<form:input path="visibility" placeholder="Visibility" />
					</div>
				</div>
				<form:errors path="visibility" cssClass="text-danger" />
				<div>
					<label for="likeCount">LikeCount:</label>
					<div>
						<form:input path="likeCount" placeholder="Like Count" />
					</div>
				</div>
				<form:errors path="likeCount" cssClass="text-danger" />
				<div>
					<form:button>Update</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>