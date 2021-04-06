<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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
if(session.getAttribute("userid") == null){
	/* Redirect to the login  */
	response.sendRedirect("index.jsp");
}
else{


out.println("Welcome " + session.getAttribute("userid") + ", you are now logged in<br><br>");
%>
<form action="getflight" method="get">
<label>From: </label>
 <input list="source" name="source" placeholder=" From ">
        <datalist id="source">
           <option value="Chicago" />
            <option value="St.Louis" />
            <option value="Orlando" />
            <option value="Tampa" />
            <option value="Newjersey" />
        </datalist>
        
 
 <label>To: </label>       
 <input list="destination" name ="destination" placeholder=" To ">
        <datalist id="destination">
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
       
<a href="logout">Logout</a>
</form>
<%

}
%>

</body>
</html>