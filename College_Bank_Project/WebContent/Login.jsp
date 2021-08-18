<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="lightgreen">
<form action="login" method="post" >
<table>
<tr>
<td>
AccountNo 
</td>
<td>
 <input type="text" name="accno" placeholder="Enter Username" required="required">
</td>
</tr>
<tr>
<td>
Password
</td>
<td>
<input type="password" name="pass" placeholder="Enter Password" required="required">
</td>
</tr>
<tr>
<td colspan="3" >
<input type="submit" value="Login">
<input type="reset" value="Reset">
<a href="SignUp.jsp" > <input type="button" value="Create New Account"></a>
</td>
</tr>
</table>
</form>
<%String s=(String)request.getAttribute("error"); %>
<%if(s!=null)
	{%>
	<%=s %>
	<%} %>
</body>
</html>