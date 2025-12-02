<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="showThis()">

<%
String value = "Welcome to Test JSP Page";
%>

<script type="text/javascript">
 var msg = '<%=value%>';
 function showThis(){
 	alert(msg);
 }
</script>


</body>
</html>