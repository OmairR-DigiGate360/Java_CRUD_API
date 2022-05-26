<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="com.helper.*" %>
<%@ page import="com.userapi.module.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of USER</title>
</head>
<body>
	<h1>List of users</h1>
	<%
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from User");
		List<User> list = q.list();
		for (User users:list)
		{
	%>
			<b><i>ID:</i></b><%= users.getId() %><br>
			<b><i>First Name:</i></i></b><%= users.getFirstName() %><br>
			<b><i>Last Name:</i></b><%= users.getLastName() %><br>
			<b><i>Email:</i></b><%= users.getEmail() %><br>
			<b><i>Number:</i></b><%= users.getPhone() %><br>
			<br>
			<button><a href="Edit.jsp?id=<%= users.getId() %>">Edit</a></button>
			<button><a href="DeleteServlet?id=<%= users.getId() %>">Delete</a></button>
			<br><br>
	<%
		}
		
		s.close();
	%>
</body>
</html>