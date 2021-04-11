<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.simplilearn.persistence.entity.Flight"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body background="https://1.bp.blogspot.com/-sTxAHAxirGM/WVbAe2098nI/AAAAAAABENs/_I5sYMYgLOUzaIE7FfF4qdGX-hoAkq9SgCLcBGAs/s1600/Blog_20170624_113552.jpg">
<%
/* Check whether user is not logged in */
if(session.getAttribute("isUsedLoggedin") == null){
	/* Redirect to the login  */
	response.sendRedirect("index.jsp");
}
else{


out.println("Welcome " + session.getAttribute("userId") + ", you are now logged in<br><br>");
%>
<form action="/maven_final/flight/search" method="POST">
<label>From: </label>
 <input list="source" name="source" placeholder=" From ">
        <datalist id="source" selected="1">
            <option value="Chicago" />
            <option value="St.Louis" />
            <option value="Orlando" />
            <option value="Tampa" />
            <option value="Newjersey" />
        </datalist>
        
 
 <label>To: </label>       
 <input list="destination" name ="destination"  placeholder=" To ">
        <datalist id="destination" >
            <option value="Chicago" />
            <option value="St.Louis" />
            <option value="Orlando" />
            <option value="Tampa" />
            <option value="Newjersey" />
        </datalist>      	
<br>
<br>
<br>
<input type="date" id="dot" name="dot"
       value="2021-05-01"
       min="2021-05-01" max="2021-12-31">
       
<input type="submit" value = "GET FLIGHTS">
       

</form>
<form action="/maven_final/user?action=LOGOUT" method="POST">
	<input type="submit" value = "LOGOUT"/>
</form>
<%

}
%>

<hr>
<h10>Search Results:</h10>
<hr>
<table style="width:60%" border="1">
<tr>
    <th><b>Source</b></th>
    <th><b>Destination</b></th>
    <th><b>Airlines</b></th>
  </tr>
	<%if(request.getAttribute("REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION")!=null){ %>
		<%
			List<Flight> searchResult=(List<Flight>)request.getAttribute("REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION");
			
			for(Flight flight:searchResult){
				
				%><tr> 
				<form action="payforflight.jsp" method="get">
				<td><%out.println(flight.getSource());
				session.setAttribute("source", flight.getSource());%></td>
				<td><%out.println(flight.getDestination());
				      session.setAttribute("destination",flight.getDestination());%></td>
				<td><%out.println(flight.getAirline());
				     session.setAttribute("airline",flight.getAirline());%></td>
				<td><input type="submit" value="BOOK FLIGHT"></td>
				
				</form>
				<tr><br><%

			}
		%>
	<%}else{ %>
		---
	<%} %>
</table>
</body>
</html>