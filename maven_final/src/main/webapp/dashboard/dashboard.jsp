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
<body>
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
<h6>Search Results:</h6>
	<%if(request.getAttribute("REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION")!=null){ %>
		<%
			List<Flight> searchResult=(List<Flight>)request.getAttribute("REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION");
			for(Flight flight:searchResult){
				out.println(flight.getAirline());

			}
		%>
	<%}else{ %>
		---
	<%} %>
</body>
</html>