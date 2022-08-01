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
					<label for="postid">PostId:</label>
					<div>
						<form:input path="postid" />
					</div>
				</div>
				<div>
					<label for="userid">UserId:</label>
					<div>
						<form:input path="userid" />
					</div>
				</div>
				<div>
					<label for="posttype">PostType:</label>
					<div>
						<form:input path="posttype" />
					</div>
				</div>
				<div>
					<label for="medialocation">MediaLocation:</label>
					<div>
						<form:input path="medialocation" />
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
					<label for="likecount">LikeCount:</label>
					<div>
						<form:input path="likecount" />
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