<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Home Page</title>
<%@ include file="/WEB-INF/css/homepage.css"%>
</style>
</head>
<body>
	<div class="main">
		<div class="dashbord">
			<div class="img">
				<img src="https://bootdey.com/img/Content/avatar/avatar6.png"
					class="img" alt="profile"><br>
				<p class="img.p">${user.userName}</p>
			</div>

			<div>
				<a href="/user/updateuser?id=${user.userId}" target="_self">
					&nbsp;
					<button id="button" class="button">Edit profile</button>
				</a>
			</div>

			<div class="menu">
				<ul>
					<li><a href="/user/finduserbyid?id=${user.userId}"
						target="_self"> <i class="fa-regular fa-circle-user"></i>
							<button id="button" class="button">About</button>
					</a><br> <br></li>
					<li><a href="/posts/getPostByUserId?id=${user.userId}"
						target="_self"> <i class="fa-light fa-image"></i>
							<button id="button" class="button">Pictures</button>
					</a><br> <br></li>
					<li><a href="/posts/addpost?userId=${user.userId}"
						target="_self"> <i class="fa-regular fa-camera"></i>
							<button id="button" class="button">Post</button>
					</a><br> <br></li>
					<li><a href="/friend/getFriendByUserId?id=${user.userId}"
						target="_self"> <i class="fa-regular fa-users"></i>
							<button id="button" class="button">Friends</button>
					</a><br> <br></li>
					<li><a href="/user/list?id=${user.userId}" target="_self">
							<button id="button" class="button">addRequest</button>
					</a><br> <br></li>
					<li><a href="/friend/requestDetails?id=${user.userId}"
						target="_self">
							<button id="button" class="button">MyRequest</button>
					</a><br> <br></li>
					<li><a href="/friend/request?id=${user.userId}" target="_self">
							<button id="button" class="button">Request</button>
					</a><br> <br></li>
					<li><div class="logout">
							<a href="/home/login"><button>Logout</button></a>
						</div></li>
				</ul>
			</div>
		</div>
		<div class="iframe">
			<iframe width="560" class="iframe" height="315" title="Post lists"
				src="/posts/list?userId=${user.userId}"></iframe>
		</div>
	</div>
</body>
</html>