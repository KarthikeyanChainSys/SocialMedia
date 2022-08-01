<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Likes</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="addlike">
				<div>
					<label for="postid">"PostId":</label>
					<div>
						<form:input path="postid" />
					</div>
				</div>
				<div>
					<label for="friendid">FriendId:</label>
					<div>
						<form:input path="friendid" />
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