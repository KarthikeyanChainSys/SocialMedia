<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style><%@include file="/WEB-INF/css/homepage.css"%></style>
</head>
<body>
	<figure>
		<img src="https://www.pinterest.com/pin/128423026849507135.jpg"
			class="img-fluid" alt="profile cover">
	</figure>
		<div>
		<div>
			<img src="https://bootdey.com/img/Content/avatar/avatar6.png"
				alt="profile"><br> <br><span class="profile-name">${user.userName}</span>
		</div>
		<div>
			<a href="/user/updateuser?id=${user.userId}" target="_self">
				&nbsp;<button id="button">Edit profile</button>
			</a>
		</div>
	</div>
	<div>
		<ul>
			<li><a href="/user/finduserbyid?id=${user.userId}"
				target="_self">
					<button id="button">About</button>
			</a><br> <br></li>
			<li><a href="/posts/getPostByUserId?id=${user.userId}" target="_self">
					<button id="button">Pictures</button>
			</a><br> <br></li>
			<li><a href="/posts/addpost" target="_self">
			<button id="button">Post</button>
			</a></li>
		</ul>
	</div>
	<div>
		<button id="button">View all</button>
	</div>
</body>
</html>