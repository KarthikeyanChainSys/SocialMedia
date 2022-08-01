<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Post</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="update" method="post" modelAttribute="updatepost">
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
						<form:input path="postType" />
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
					<label for="dates">Date:</label>
					<div>
						<form:input path="dates" />
					</div>
				</div>
				<div>
					<label for="times">Time:</label>
					<div>
						<form:input path="times" />
					</div>
				</div>
				<div>
					<label for="likeCount">LikeCount:</label>
					<div>
						<form:input path="likeCount" />
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