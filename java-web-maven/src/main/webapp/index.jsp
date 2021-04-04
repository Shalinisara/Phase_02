<html>
<body>
<% 
String uname=request.getParameter("Name"); 
out.print("Welcome "+ uname);
session.setAttribute("sessname",uname); 
%> 

</body>
</html>
