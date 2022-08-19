<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style><%@include file="/WEB-INF/css/signup.css"%></s</style>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<button class="button"
        onclick="history.back()">Go Back</button>
	<h1>Create an Account</h1>
	<div class="container">
			<form:form action="add" method="post" modelAttribute="adduser">
					<label for="userName">UserName:</label>
					<div>
						<form:input path="userName" name="userName" title="User name can't be empty" placeholder="UserName"
							required="true" pattern="^[A-Za-z]\\w{3,20}$" onblur="userNameCheck();" />
					</div>
					<label for="email">Email:</label>
					<div>
						<form:input path="email" type="email" title="Mail Id is not in correct format" placeholder="example@domain.com"
							required="true" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" name="email" onblur="emailCheck();" />
					</div>
					<label for="password">Password:</label>
					<div>
						<form:input path="password" type="password" required="true"
							title='Password must begin with letter and contain atleast one number and must have atleast 8 characters' 
							placeholder="Enter the password" name="password" onblur="passwordCheck();"
							pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" />
					</div>
					<label for="dob">DOB</label>
					<div>
						<form:input path="dob" type="date" />
					</div>
					<label for="country">Country:</label>
					<div>
						<form:input path="country" name="country" placeholder="Country" title="Country can't be empty"
							required="true" pattern="^[a-zA-z\s]+$" onblur="countryCheck();"/>
					</div>
					<label for="joiningDate">JoiningDate:</label>
					<div>
						<form:input path="joiningDate" type="date" />
					</div>
					<label for="gender">Gender:</label>
					<div>
                        <form:radiobutton path="gender" value="Male" required="required"/>Male
                        <form:radiobutton path="gender" value="Female" />Female
                    </div>
                    <div class="container.button1">
					<form:button class="button1">Sign up</form:button>
					</div>
				<h2>Create an account and get lot of new good friends</h2>
			</form:form>
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