<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background: #8e9eab;  /* fallback for old browsers */
background: -webkit-linear-gradient(to top, #eef2f3, #8e9eab);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to top, #eef2f3, #8e9eab); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}
.banner{
background: #00d2ff;  /* fallback for old browsers */
background: -webkit-linear-gradient(to bottom, #3a7bd5, #00d2ff);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to bottom, #3a7bd5, #00d2ff); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
</style>
<meta charset="ISO-8859-1">
<title>FlyAway - Verify Flight selection</title>
</head>
<body>
<div class="banner">
FlyAway - Verify Flight selection
</div>
<h1>Please Verify the travel details</h1><br>
<h3>Source</h3> <%out.println(request.getParameter("selectedSource"));%>
<br>
<h3>Destination</h3> <%out.println(request.getParameter("selectedDestination"));%>
 <br>
 <h3>Airline</h3><%out.println(request.getParameter("selectedAirline"));%>
  <br>
</body>
</html>