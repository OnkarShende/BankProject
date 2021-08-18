<%@page import="com.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Created</title>
</head>

<body bgcolor="lightgreen">

<%User u=(User)request.getAttribute("user"); %>

<h1>Hello <%=u.getName()%>, Account Created Successfully.</h1>

<h4>     
Name = <%=u.getName() %> <br>
UserName = <%=u.getUsername() %> <br>
Account No = <%=u.getAccountno() %> <br>
Password = <%=u.getPassword() %> <br>
Balance = <%=u.getBalance() %>
</h4>
 <a href="Login.jsp"> <input type="button" value="Home"></a>
</body>
</html>