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
<title>Insert title here</title>
</head>
<body>
	<%
		int userId = Integer.parseInt(request.getParameter("id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		User user = s.get(User.class, userId);
	%>
	<form action="update" method="post">
		<input type="hidden" name="id" value="<%= user.getId() %>"> <br>
		First Name: <input type="text" name="fname" value="<%= user.getFirstName() %>"> <br>
		Last Name: <input type="text" name="lname" value="<%= user.getLastName() %>"> <br>
		Email: <input type="text" name="email" value="<%= user.getEmail() %>"> <br>
		Phone: <input type="text" name="phone" value="<%= user.getPhone() %>"> <br>
		<input type="submit" value="Update">
	</form>
</body>
</html>