<%@page import="com.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body bgcolor="lightgreen" >

<%User u=(User)request.getAttribute("user"); %>

<h2>Dear <%=u.getName()%> Welcome to DEMO BANK</h2>

<h4>
Account No = <%=u.getAccountno()%> <br>

Name = <%=u.getName() %> <br>

UserName = <%=u.getUsername() %> <br>

Total Balance = <%=u.getBalance() %>
</h4>

<form action="deposit">
<input type="hidden" name="laccno" value="<%=u.getAccountno()%>">
<input type="submit" value="Deposit" >
</form>

<form action="withdraw">
<input type="hidden" name="laccno" value="<%=u.getAccountno()%>">
<input type="submit" value="Withdraw" >
</form>

<form action="change">
<input type="hidden" name="laccno" value="<%=u.getAccountno()%>">
<input type="submit" value="Update Details" >
<br>
<a href="Login.jsp" ><input type="button" value="Logout"></a>
</form>

<br>
<%String s=(String)request.getAttribute("msg"); %>
<%if(s!=null)
{%>
<%=s %>
<%} %>

</body>
</html>