<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style><%@include file="/WEB-INF/css/homepage.css"%>
.iframe {
    position: absolute;
    top:110%;
    right: 25%;
    width: 700px;
    height: 500px;
    margin-top: -400px;
    margin-right: 20px;
    z-index: 999;
    border-radius:20px;
} 
</style>
</head>
<body>
	<figure>
		<img src="https://www.bootdey.com/img/Content/bg1.jpg" alt="profile cover" class="img.profile">
	</figure>
		<div>
		<div>
			<img src="https://bootdey.com/img/Content/avatar/avatar6.png" class="img"
				alt="profile"><br><p class="img.p">${user.userName}</p>
		</div>
		<br>
		<div>
			<a href="/user/updateuser?id=${user.userId}" target="_self">
				&nbsp;<button id="button">Edit profile</button>
			</a>
		</div><br>
		<hr>
	</div>
	<div>
	<iframe width="560" class="iframe" height="315" title="Post lists" src="/posts/list?userId=${user.userId}"></iframe>
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
			<li><a href="/posts/addpost?userId=${user.userId}" target="_self">
			<button id="button">Post</button>
			</a><br> <br></li>
			<li><a href="/friend/getFriendByUserId?id=${user.userId}" target="_self">
			<button id="button">Friend</button>
			</a></li>
			<li><a href="/user/list?id=${user.userId}" target="_self">
			<button id="button">addRequest</button>
			</a></li>
			<li><a href="/friend/list?id=${user.userId}" target="_self">
			<button id="button">Request</button>
			</a></li>
		</ul>
	</div>
</body>
</html>