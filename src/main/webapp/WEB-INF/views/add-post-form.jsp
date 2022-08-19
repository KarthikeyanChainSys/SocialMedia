<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Add Post</title>
<style><%@ include file="/WEB-INF/css/post.css"%></s</style>
</head>
<body>        
	<div id="root">
	<button class="button"
        onclick="history.back()">Go Back</button>
        <div class="container">
		<div class="form">
			<form:form action="add" method="post" enctype="multipart/form-data" modelAttribute="addpost" >
				<div class="form">
					<div>
						<form:hidden path="userId" />
					</div><br>
					<label for="post">Post:</label>
					<div>
						<input name="photo" type='file' placeholder='file' accept='audio/*,video/*,image/*' />
					</div><br>
					<label for="mediaLocation">MediaLocation:</label>
					<div>
						<form:input path="mediaLocation" placeholder="Media Location" required="true" pattern="^[A-Za-z]\\w{3,20}$" onblur="mediaLocation();" />
					</div><br>
					<label for="visibility">Visibility:</label>
					<div>
						<form:input path="visibility" placeholder="Visibility" required="true" pattern="^[A-Za-z]\\w{3,20}$" onblur="visibility();"/>
					</div><br>
				<br>
				<div>
					<form:button class="button1">Add</form:button>
				</div>
				</div>
			</form:form>
		</div>
		</div>
	</div>
	<script type="text/javascript">
	 var visibility = function() {
		 var nameRegex = new RegExp("^[A-Za-z]\\w{3,20}$");
		 if(!document.form.visibility.value.match(nameRegex)){
				if(alert("visibility can't be empty and must contain only alphabets")){ 
					 document.form.visibility.focus();
			    }
				else
					document.activeElement.blur();
			}
	    else{
	        return false;
	    }  
	}
	 var mediaLocation = function() {
		 var nameRegex = new RegExp("^[A-Za-z]\\w{3,20}$");
		 if(!document.form.mediaLocation.value.match(nameRegex)){
				if(alert("mediaLocation can't be empty and must contain only alphabets")){ 
					 document.form.mediaLocation.focus();
			    }
				else
					document.activeElement.blur();
			}
	    else{
	        return false;
	    }  
	}
	</script>
</body>
</html>