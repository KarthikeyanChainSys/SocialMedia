<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Friend</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="addfriend">
				<div>
					<label for="friendid">FriendId:</label>
					<div>
						<form:input path="friendid" />
					</div>
				</div>
				<div>
					<label for="userid">UserId:</label>
					<div>
						<form:input path="userid" />
					</div>
				</div>
				<div>
					<label for="requeststatus">RequestStatus:</label>
					<div>
						<form:input path="requeststatus" />
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