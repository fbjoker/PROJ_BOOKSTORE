<%@page import="java.util.ArrayList"%>
<%@page import="com.doufu.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "kk", "aksdfj", "asdf"));
		list.add(new User(2, "ss", "aksdfj", "asdf"));
		list.add(new User(3, "dd", "aksdfj", "asdf"));
		list.add(new User(4, "ff", "aksdfj", "asdf"));
	%>
	
	<table border="1px">
	<%
		for(User user:list){
			
		
	%>
	
	<tr>
	<td><%= user.getId() %></td>
	<td><%= user.getUsername() %></td>
	<td><%= user.getPassword() %></td>
	<td><%= user.getEmail() %></td>
	</tr>
	
	<%} %>
	
	</table>

</body>
</html>