<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body bgcolor="lightgreen" >

<form action="signup" method="post" >

<table align="center" >
<tr>
<td>
Name
</td>
<td>
<input type="text" name="name" placeholder="Enter Name" required="required">
</td>
</tr>
<tr>
<td>
Select Account No
</td>
<td>
<input type="number" name="accno" placeholder="Select Account No" required="required">
</td>
</tr>
<tr>
<td>
Balance
</td>
<td>
<input type="number" name="initbal" placeholder="Enter Amount" required="required">
</td>
</tr>
<tr>
<td>
UserName
</td>
<td>
<input type="text" name="uname" placeholder="Enter Name" required="required">
</td>
</tr>
<tr>
<td>
Password
</td>
<td>
<input type="text" name="pass" placeholder="Enter Password" required="required">
</td>
</tr> 

</table>
<pre>
<center>
 <input type="submit"  value="Create Account">  <input type="reset" value="Reset"> <a href="Login.jsp"> <input type="button" value="Cancel"></a>
</center>
</pre>

<%String s=(String)request.getAttribute("error"); %>
<%if(s!=null)
{%>

<%=s %>

<%} %>

</form>

</body>
</html>