<div>
	<a href="." target="_blank">Home</a> |
	<a href=".">About Us</a> |
	<a href=".">Contact Us</a>|
</div>
<hr>
<%
if(session == null || session.getAttribute("name") == null)
{
%>
<div style="float:right;">
	<a href="<%=request.getContextPath()%>/jsp/Login.jsp">Login</a> |
	<a href="<%=request.getContextPath()%>/jsp/Register.jsp">Register</a>
</div>
<% } %>