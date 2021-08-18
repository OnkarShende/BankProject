<%@page import="com.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Money</title>
</head>

<body bgcolor="lightgreen" >

<form action="withdrawtransact" method="post" > 

<%User u=(User)request.getAttribute("user");%>

<input type="hidden"  name="laccno" value="<%=u.getAccountno()%>"  ><br>
<input type="hidden" name="oldbal" value="<%=u.getBalance()%>" > <br>

Enter Withdraw Amount = <input type="number" name="wvalue" placeholder="Enter Withdraw Amount"> <br><br>

<input type="submit" value="Withdraw">

<!-- <a href="LoginSuccess.jsp" ><input type="button" value="Home"></a> -->

<a href="Login.jsp"><input type="button" value="Logout"></a>
</form>

<%String s=(String)request.getAttribute("error"); %>

<%if(s!=null)
{%>
	<%=s %>
<%} %>

</body>
</html>