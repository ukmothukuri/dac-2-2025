<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>

<%
  String msg = "";
	if(request.getParameter("msg") != null){
		msg = request.getParameter("msg");
	}
%>


	<script>
		function validateUserName() {
			if (document.getElementById("username").value === "") {
				alert("User Name cannot be empty");
				return false;
			}
			return true;
		}

		function validateUserEmail() {
			if (document.getElementById("useremail").value === "") {
				alert("User Email cannot be empty");
				return false;
			}
			return true;
		}

		function validateUserMobile() {
			if (document.getElementById("usermobile").value == "") {
				alert("User Mobile cannot be empty");
				return false;
			} else if (document.getElementById("usermobile").value.length != 10) {
				alert("Entered Mobile is not valid. Should have 10 digits");
				return false;
			}
			return true;
		}

		function validateUserPassword() {
			if (document.getElementById("userpassword").value == "") {
				alert("User Password cannot be empty");
				return false;
			} else if (document.getElementById("userconfirmpassword").value == "") {
				alert("Confirm Password cannot be empty");
				return false;
			} else if (document.getElementById("userpassword").value != document
					.getElementById("userconfirmpassword").value) {
				alert("Password and Confirm password are not the same");
				return false;
			}
			return true;
		}

		function validateAllFields() {
			return validateUserName() && validateUserEmail()
					&& validateUserMobile() && validateUserPassword()
		}
	</script>
	<br>
	<center>
	
	<%
	 if(msg != "" && msg.equals("success")){
	%>
		<h2 style="color:green">Your registration is successful. Please login	</h2>
	<% 
	 } else if(msg != "" && msg.equals("fail")){
	%>
	   <h2 style="color:red">Failed to complete the registration. Please contact your admin</h2>
	<%
	 } else if(msg != "") {
	%>
	<h2 style="color:red"><%= msg%></h2>
	<%		 
	 }
	%>	
	<form action="../UserRegistration" method="post">
		UserName : <input type="text" id="username" name="username" /> <br>
		Email: <input type="email" id="useremail" name="useremail" /> <br>
		Mobile: <input type="text" id="usermobile" name="usermobile">
		<br>
		<br> 
		Password: <input type="password" id="userpassword"
			name="userpassword" /><br> 
		Confirm Password: <input
			type="password" id="userconfirmpassword" /> <br> <input
			type="submit" value="Register" onclick="validateAllFields()" />
	</form>
	</center>
	<%@ include file="Footer.jsp" %>
</body>
</html>