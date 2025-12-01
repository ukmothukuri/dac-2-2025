<%@page import="java.util.ArrayList"%>
<%@page import="in.cdac.ecomm.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
 List<Product> products = (ArrayList<Product>) request.getAttribute("products");
%>

<table border="solid">
<tr>
<th>ID</th>
<th>Product Name</th>
<th>Price</th>
<th>Year of Manf</th>
</tr>
<%
	for(Product p : products)
	{	
%>
	<tr>
	<td><%=p.getProductId() %></td>
	<td><%=p.getProductName() %></td>
	<td><%=p.getPrice() %></td>
	<td><%=p.getManufacturedYear() %></td>
	</tr>
<%
	}
%>
</table>


</body>
</html>