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
	<div class="profile-page tx-13">
		<div class="profile-header">
			<div class="cover">
				<figure>
					<img src="https://www.pinterest.com/pin/128423026849507135.jpg"
						class="img-fluid" alt="profile cover">
				</figure>
				<div
					class="cover-body d-flex justify-content-between align-items-center">
					<div>
							<img class="profile-pic"
								src="https://bootdey.com/img/Content/avatar/avatar6.png"
								alt="profile">
							<span class="profile-name">${users.userName}</span>
					</div>
					<div class="d-none d-md-block">
					<button id="button"  class="btn btn-primary btn-icon-text btn-edit-profile">
								<a href="updateuser?id=${user.userId}" target="_self">Edit profile</a>
							</button>
					</div>
				</div>
			</div>
			<div class="header-links">
				<ul class="links d-flex align-items-center mt-3 mt-md-0">
					<li
						class="header-link-item ml-3 pl-3 border-left d-flex align-items-center">
						<button id="button">
								<a href="/user/finduserbyid" target="_self">About</a>
							</button> <br> <br>
					</li>
					<li
						class="header-link-item ml-3 pl-3 border-left d-flex align-items-center">
						<button id="button">
								<a href="/post/findpostbyid" target="_self">Photos</a>
							</button> <br> <br>
					</li>
					<li
						class="header-link-item ml-3 pl-3 border-left d-flex align-items-center">
						<button id="button">
								<a href="/post/findpostbyid" target="_self">Videos</a>
							</button>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="row profile-body">
		<div class="d-none d-md-block col-md-4 col-xl-3 left-wrapper">
			<div class="card rounded">
				<div class="card-body">
					<div class="d-flex align-items-center justify-content-between mb-2">
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<button id="button">Edit</button>
							<button id="button">View all</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>