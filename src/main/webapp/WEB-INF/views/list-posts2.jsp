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
	<div><br>
		Id : ${post.userId}&nbsp;&nbsp;&nbsp;
		Date : ${post.date}&nbsp;&nbsp;&nbsp;
		Time : ${post.time}&nbsp;&nbsp;&nbsp;
	</div>
	<div><br>
		${post.posts}
		<img width="400" height="300" src="getimage?id=${post.postId}" alt="image"><br>
		${post.mediaLocation}<br>&nbsp;&nbsp;&nbsp;
		<a href="/like/addlike?id=${post.postId}&fid=${userId}" target="_self" >
		<button type="button" class="btn btn-info"><em class="fa-regular fa-thumbs-up"></em> Like ${post.likeCount}</button></a>
		&nbsp;&nbsp;&nbsp;
		<a href="/comment/addcomment?id=${post.postId}">
		<button type="button" class="btn btn-info" >
		<em class="fa-regular fa-comment"></em> Comment</button></a>&nbsp;&nbsp;&nbsp;
	</div>
	</div>
	<hr>
	</c:forEach>
</body>
</html>