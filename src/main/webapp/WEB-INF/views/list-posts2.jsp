<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
		Id : ${post.userId}
		Date : ${post.date}
		Time : ${post.time}
	</div>
	<div>
		${post.posts}
		<img width="350" height="250" src="getimage?id=${post.postId}" alt="image"><br>
		${post.mediaLocation}<br>
		<a href="/posts/deletepost2?id=${post.postId}" target="_self"><em class="fa fa-trash-o"></em>Delete</a>&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo"><em class="fa-regular fa-comment"></em> Comment</button>&nbsp;&nbsp;&nbsp;
 			<div id="demo" class="collapse">
   		<iframe src="/comment/addcomment?id=${post.postId}&fid=${post.userId}" title="comments" class="iframe" class="box"> </iframe>
 			 </div>
		<a href="/like/addlike" target="_self" onclick="clickCounter();"><em class="fa-regular fa-thumbs-up"></em>like</a>	
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