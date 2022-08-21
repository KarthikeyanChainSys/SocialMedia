<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Friend List</title>
<style><%@include file="/WEB-INF/css/friends.css"%></style>
</head>
<body>
	<button class="button1"
        onclick="history.back()">Go Back</button>
<script type="text/javascript">
$(window).on("load resize ", function() {
	  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
	  $('.tbl-header').css({'padding-right':scrollWidth});
	}).resize();
</script>
<form>
<div class="form">
	<table class="table">
		<caption></caption>
		<thead class="tbl-header">
			<tr>
				<th>UserId</th>
				<th>FriendId</th>
				<th>RequestStatus</th>
				<th>UnFriend</th>
			</tr>
		</thead>
		<tbody class="tbl-content">
			<c:forEach var="friends" items="${allfriend}">
				<tr>
					<td>${friends.userId}</td>
					<td>${friends.friendId}</td>
					<td>${friends.requestStatus}</td>
					<td><a href="/friend/deletefriend?id=${friends.friendId}&userId=${friends.userId}">
						<button class="button" type="button">UnFriend </button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</form>
</body>
</html>