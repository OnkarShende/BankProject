<%@page import="com.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Money</title>
</head>
<body bgcolor="lightgreen" >

<form action="transactdeposit" method="post" >

<%User u=(User)request.getAttribute("user");%>

<input type="hidden"  name="laccno" value="<%=u.getAccountno()%>"  ><br>
<input type="hidden" name="oldbal" value="<%=u.getBalance()%>" > <br>

Enter Amount:- <input type="number" name="dvalue" placeholder="Enter Amount to Deposit"><br><br>

<input type="submit" value="Deposit">

<!-- <!-- <a href="LoginSuccess.jsp"><input type="button" value="Home"></a> -->

<a href="Login.jsp"><input type="button" value="Logout"></a>
</form> 



<%String s=(String)request.getAttribute("error"); %>

<%if(s!=null)
{%>
	<%=s %>
<%} %>
</body>
</html>