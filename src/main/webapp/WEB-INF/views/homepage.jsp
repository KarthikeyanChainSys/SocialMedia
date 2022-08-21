<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
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
				<a href="/user/updateuser?id=${user.userId}" target="_self">
					&nbsp;
					<button id="button" class="button">Edit profile</button>
				</a><br>
			</div>

			<div class="menu">
				<ul>
					<li><a href="/user/finduserbyid?id=${user.userId}"
						target="_self">About
					</a><br> <br></li>
					<li><a href="/posts/getPostByUserId?id=${user.userId}"
						target="_self">Pictures
					</a><br> <br></li>
					<li><a href="/posts/addpost?userId=${user.userId}"
						target="_self">Post
					</a><br> <br></li>
					<li><a href="/friend/getFriendByUserId?id=${user.userId}"
						target="_self">Friends
					</a><br> <br></li>
					<li><a href="/user/list?id=${user.userId}" target="_self">Send Request
					</a><br> <br></li>
					<li><a href="/friend/requestDetails?id=${user.userId}"target="_self">Request Status
					</a><br> <br></li>
					<li><a href="/friend/request?id=${user.userId}" target="_self">Friends Request
					</a><br> <br></li>
					<li><a href="/home/login" class=button1>Logout</a></li>
				</ul>
			</div>
		</div>
		<div class="iframe">
			<iframe width="560" class="iframe" height="315" title="Post lists"
				src="/posts/list2?userId=${user.userId}"></iframe>
		</div>
	</div>
</body>
</html>