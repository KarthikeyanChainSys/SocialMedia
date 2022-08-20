<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Add Friend</title>
<style><%@ include file="/WEB-INF/css/post.css"%></s</style>
</head>
<body>
<div id="root">
<button class="button"
        onclick="history.back()">Go Back</button>
	<div class="container">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="addfriend">
				<div class="form">
					<div>
						<form:input path="userId" placeholder="Friend Id" type="hidden"/>
					</div>
					<div>
						<form:input path="friendId" placeholder="Friend Id" type="hidden" />
					</div>
					<label for="requestStatus">RequestStatus:</label>
					<div>
						<form:input path="requestStatus" placeholder="Request Status" />
					</div>
				<div>
					<form:button class="button1">Add</form:button>
				</div>
				</div>
			</form:form>
		</div>
		</div>
	</div>
</body>
</html>