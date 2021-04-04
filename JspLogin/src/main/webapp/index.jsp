<html>
<body>
<% 
String username=request.getParameter("Name"); 
out.print("Welcome "+ username);
session.setAttribute("sessname",username); 
%> 
<a href="output.jsp">Check Output Page Here </a>
</body>
</html>
