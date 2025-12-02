<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=getServletContext().getInitParameter("projectName") %></title>
</head>
<body>

<%-- This is start of Home.JSP --%>
 
	<%@ include file="Header.jsp" %> 
	
	
	<%@ include file="Gallery.jsp" %>
	
	<%@ include file="Content.jsp" %>
	
	<%@ include file="Footer.jsp" %>
	
<!-- This is the end of Home.JSP -->
</body>
</html>