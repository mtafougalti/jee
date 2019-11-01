<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hello World Application</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		name = name==null ? "World" : name;
	%>
	<h3> Hello <%out.print(name); %> from JSP</h3>
</body>
</html>