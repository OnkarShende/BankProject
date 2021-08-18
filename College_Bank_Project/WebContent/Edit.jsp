<%@page import="com.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body bgcolor="lightgreen" >
<form action="update">
<pre>
<%User u=(User)request.getAttribute("user");%>
 <input type="hidden" name="laccno" value="<%=u.getAccountno()%>">
Name =       <input type="text" name="name" value="<%=u.getName() %>"> 
UserName =   <input type="text" name="uname" value="<%=u.getUsername() %>" >
Password =   <input type="text" name="pass" value="<%=u.getPassword() %>" >

<input type="submit" value="Update Changes" > <a href="Login.jsp" ><input type="button" value="Logout"></a>
</pre>

</form>
</body>
</html>