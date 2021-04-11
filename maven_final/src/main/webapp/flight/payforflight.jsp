<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Please Verify the travel details</h1><br>
<h3>Source</h3> <%out.println(session.getAttribute("source"));%>
<br>
<h3>Destination</h3> <%out.println(session.getAttribute("destination"));%>
 <br>
 <h3>Airline</h3><%out.println(session.getAttribute("airline"));%>
  <br>
</body>
</html>