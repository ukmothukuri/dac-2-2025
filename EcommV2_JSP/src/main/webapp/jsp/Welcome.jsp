<%@ include file="Header.jsp" %> 

<%
 String username = (String)session.getAttribute("name");
%>

<div style="float:right">
	Welcome <%=username %> |
	<a href="./Logout">Logout</a>
</div>

<%@ include file="SubHeader.jsp" %>

<div style="margin-top:20px; margin-bottom:10px">


</div>

<%@ include file="Footer.jsp" %>