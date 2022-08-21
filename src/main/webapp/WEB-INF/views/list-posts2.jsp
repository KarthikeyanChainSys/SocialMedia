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
		<a href="/posts/deletepost?id=${post.postId}" target="_self">
		<button type="button" class="btn btn-info">Delete</button></a>&nbsp;&nbsp;&nbsp;
		
 			<div>
   		<iframe id="iframe" class="iframe" src="/comment/addcomment?id=${post.postId}&fid=${post.userId}" title="comments" > 
   			<button type="button" class="btn btn-info" onclick='show("iframe")'><em class="fa-regular fa-comment"></em> Comment</button>&nbsp;&nbsp;&nbsp;
   		</iframe>
 			 </div>
		<a href="/like/addlike?id=${post.postId}&fid=${userId}" target="_self" ><button type="button" class="btn btn-info"><em class="fa-regular fa-thumbs-up"></em> Like</button></a>	
	</div>
	</div>
	<hr>
	</c:forEach>
	<script type="text/javascript">
	function show(elementID) {
		var myElement = document.getElementById(elementID);
		if (myElement) myElement.style.display = "block";
	}
	function hide(elementID) {
		var myElement = document.getElementById(elementID);
		if (myElement) myElement.style.display = "none";
	}
	</script>
</body>
</html>