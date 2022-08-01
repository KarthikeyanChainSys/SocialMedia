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
					<label for="postid">PostId:</label>
					<div>
						<form:input path="postid" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="userid">UserId:</label>
					<div>
						<form:input path="userid" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="posttype">PostType:</label>
					<div>
						<form:input path="posttype" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="medialocation">MediaLocation:</label>
					<div>
						<form:input path="medialocation" readonly="true"/>
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
					<label for="likecount">LikeCount:</label>
					<div>
						<form:input path="likecount" readonly="true"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>