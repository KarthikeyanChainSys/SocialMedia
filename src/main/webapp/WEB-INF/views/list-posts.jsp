<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
<meta charset="ISO-8859-1">
<title>Post List</title>
<style><%@include file="/WEB-INF/css/form.css"%>
</style>
</head>
<body>
	<script type="text/javascript">
	$('#foo').click(function() {
	    var button = $(this),
	        commentField = $('<textarea/>');
	        .val(button.data('textContent') || 'This is my comment field\'s text')
	        .keypress(function(e) {
	            if (e.which === 13) {
	                e.preventDefault();
	                button.data('textContent', this.value);
	                $(this).remove();
	            }
	        })
	        .appendTo(document.body);
	});
	</script>
	<c:forEach var="post" items="${allpost}">
	<div id="table root">
		${post.userId}
		${post.date}
		${post.time}
	</div>
	<div>
		${post.posts}
		${post.mediaLocation}
		<a href="deletepost?id=${post.postId}">Delete</a>
		<i class="fa-regular fa-comment"></i>
	</div>
	</c:forEach>	
</body>
</html>
	
	
	
	
	