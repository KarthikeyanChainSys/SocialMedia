<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<style><%@include file="/WEB-INF/css/update.css"%></style>
</head>
<body>
<button class="button"
        onclick="history.back()">Go Back</button>
		<div class="container">
		<div class="form">
			<form:form style="text-align:center" action="update" method="post" modelAttribute="updateuser">
					<div class="form">
					<div>
						<form:hidden path="userId" />
					</div>
					<label for="email">Email:</label>
					<div>
						<form:input class="form" path="email" type="email" title="Mail Id is not in correct format" placeholder="example@domain.com"
							required="true" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" name="email" onblur="emailCheck();" />
					</div>
					<label for="password">Password:</label>
					<div>
						<form:input class="form" path="password" type="password" required="true"
							title='Password must begin with letter and contain atleast one number and must have atleast 8 characters' 
							placeholder="Enter the password" name="Password" onblur="passwordCheck();"
							pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" />
					</div>
					<label for="userName">UserName:</label>
					<div>
						<form:input class="form" path="userName" name="userName" title="User name can't be empty" placeholder="UserName"
							required="true" pattern="^[A-Za-z]\\w{3,20}$" onblur="userNameCheck();" />
					</div>
					<label for="dob">DOB</label>
					<div>
						<form:input class="form" path="dob" type="date" />
					</div>
					<label for="country">Country:</label>
					<div>
						<form:input class="form" path="country" name="country" placeholder="Country" title="Country can't be empty"
							required="true" pattern="^[a-zA-z\s]+$" onblur="countryCheck();"/>
					</div>
					<label for="joiningDate">JoiningDate:</label>
					<div>
						<form:input class="form" path="joiningDate" type="date" />
					</div>
					<label for="gender">Gender:</label>
					<div>
						<form:input path="gender" placeholder="Gender" required="true" pattern="^[a-zA-z\s]+$" onblur="countryCheck();" />
					</div><br>
					<div class="container.button1">
						<form:button class="button1">Update</form:button>
					</div>
					</div>
			</form:form>
		</div>
		</div>
	<script type="text/javascript">
	 var userNameCheck = function() {
		 var nameRegex = new RegExp("^[A-Za-z]\\w{3,20}$");
		 if(!document.form.userName.value.match(nameRegex)){
				if(alert("Name can't be empty and must contain only alphabets")){ 
					 document.form.userName.focus();
			    }
				else
					document.activeElement.blur();
			}
	    else{
	        return false;
	    }  
	}
	 
	 var countryCheck = function() {
		 var nameRegex = new RegExp("^[a-zA-z\s]+$");
		 if(!document.form.country.value.match(nameRegex)){
				if(alert("Country can't be empty and must contain only alphabets")){ 
					 document.form.country.focus();
			    }
				else
					document.activeElement.blur();
			}
	    else{
	        return false;
	    }  
	}
	 
	 var emailCheck = function() {
		 var nameRegex = new RegExp("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		 if(!document.form.email.value.match(nameRegex)){
				if(alert("Email not in the correct format")){ 
					 document.form.email.focus();
			    }
				else
					document.activeElement.blur();
			}
	    else{
	        return false;
	    } 
	   
	}
	 
	 var passwordCheck = function() {
		 var nameRegex = new RegExp("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
		 if(!document.form.password.value.match(nameRegex)){
				if(alert("Password must begin with letter and contain atleast one number and must have atleast 8 characters")){ 
					 document.form.password.focus();
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