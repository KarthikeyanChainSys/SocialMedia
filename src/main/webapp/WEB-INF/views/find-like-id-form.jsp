<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Find Like Id</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="" method="get" modelAttribute="findlikebyid">
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
					<label for="dateTime">DateTime:</label>
					<div>
						<form:input path="dateTime" readonly="true" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>