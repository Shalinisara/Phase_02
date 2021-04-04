<html>
<body>
<%
/* Check whether the user is already logged in */
if(session.getAttribute("userid") != null)
{
	/* Redirect to dashboard */
	response.sendRedirect("dashboard.jsp");
}
%>
<h2>Login</h2>
<hr>
<form action="authenticate">
<input type="text" name = "userid" placeholder="Your Name"><br>
<input type="submit" value = "LOGIN">
</form>
</body>
</html>
