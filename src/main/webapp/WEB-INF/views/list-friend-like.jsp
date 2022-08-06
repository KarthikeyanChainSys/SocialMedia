<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Like Friend and Like</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="getfriend">
				<div>
					<label for="friendId">FriendId:</label>
					<div>
						<form:input path="friendId" />
					</div>
				</div>
				<div>
					<label for="userId">UserId:</label>
					<div>
						<form:input path="userId" />
					</div>
				</div>
				<div>
					<label for="requestStatus">RequestStatus:</label>
					<div>
						<form:input path="requestStatus" />
					</div>
				</div>
			</form:form>
		</div>
		<div id="table root"></div>
		<table border="2" width="100%" cellpadding="2">
			<thead>
				<tr>
					<th>PostId</th>
					<th>FriendId</th>
					<th>DateTime</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="like" items="${likelist}">
					<tr>
						<td>${like.postId}</td>
						<td>${like.friendId}</td>
						<td>${like.dateTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>