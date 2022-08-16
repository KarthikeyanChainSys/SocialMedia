<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
	<div class="div">
	<div>
		${post.userId}
		${post.date}
		${post.time}
	</div>
	<div>
		${post.posts}
		${post.mediaLocation}<br>
		<a href="/posts/deletepost?id=${post.postId}" target="_self"><i class="fa fa-trash-o"></i>Delete</a>&nbsp;&nbsp;
		<a href="/comment/addcomment" class="foo" target="_blank" ><i class="fa-regular fa-comment"></i>comment</a>&nbsp;&nbsp;
		<a href="/like/addlike" target="_blank" onclick="clickCounter"><i class="fa-regular fa-thumbs-up"></i>like</a>
	</div>
	</div>
	<hr>
	</c:forEach>
	<script type="text/javascript">
	function clickCounter() {
		if(typeof(Storage) != "undefined"){
			if(localStorage.clickcount){
				localStorage.clickcount = Number(localStorage.clickcount)+1;
				var click = localStorage.clickcount
				if(localStorage.clickcount % 2 ==0){
					var click = 0
					console.log(click)
				}
				else{
					var click = 1
					console.log(click)
				}
			}
			else{
				localStorage.clickcount = 1;
			}
			document.getElementById("result").innerHTML = click;
		} else{
			document.getElementById("result").innerHTML = "Sorry, your browser does not support web storage...";
		}
	}
	</script>
</body>
</html>
	
	
	
	
	