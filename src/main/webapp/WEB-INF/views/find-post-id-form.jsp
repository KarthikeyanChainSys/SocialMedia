<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Post Id</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="" method="get" modelAttribute="findpostbyid">
				<div>
					<label for="postId">PostId:</label>
					<div>
						<form:input path="postId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="userId">UserId:</label>
					<div>
						<form:input path="userId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="postType">PostType:</label>
					<div>
						<form:input path="postType" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="mediaLocation">MediaLocation:</label>
					<div>
						<form:input path="mediaLocation" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="visibility">Visibility:</label>
					<div>
						<form:input path="visibility" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="dates">Date:</label>
					<div>
						<form:input path="dates" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="times">Time:</label>
					<div>
						<form:input path="times" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="likeCount">LikeCount:</label>
					<div>
						<form:input path="likeCount" readonly="true"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>