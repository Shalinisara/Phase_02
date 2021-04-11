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
</head>
<body>

<div class="banner">
<%
/* Check whether user is not logged in */
if(session.getAttribute("isUsedLoggedin") == null){
	/* Redirect to the login  */
	response.sendRedirect("index.jsp");
}
else{


out.println("Welcome " + session.getAttribute("userId") + "!, you are now logged in<br><br>");
%>
</div>
<br/>
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
			int index=0;
			for(Flight flight:searchResult){
				
				%><tr> 
				<div>
				<form action="payforflight.jsp" method="post" id=<%=index%>>
				<input type="hidden" name="selectedSource" value=<%=flight.getSource()%>/>
				<input type="hidden" name="selectedDestination" value=<%=flight.getDestination()%>/>
				<input type="hidden" name="selectedAirline" value=<%=flight.getAirline()%>/>
				
				<td><%out.println(flight.getSource());%></td>
				<td><%out.println(flight.getDestination());%></td>
				<td><%out.println(flight.getAirline());%></td>
				<td><input type="submit" value="BOOK FLIGHT"></td>
				
				</form>
				</div>
				<tr><br><%
				index++;
			}
		%>
	<%}else{ %>
		---
	<%} %>
</table>
</body>
</html>