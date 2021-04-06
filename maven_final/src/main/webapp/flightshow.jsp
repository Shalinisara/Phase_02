<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" > 
		
			<tr bgcolor="00FF7F"> 
				<th>Source</th> 
				<th>Destination</th> 
				<th>Flight name</th> 
			</tr>
			      <%List<Flights> theflight = (List<Flights>)request.getAttribute("tempflights");
        for(Flights s:theflight){%>
        
       
            <tr>
                <td><%=s.getSource()%></td>
                <td><%=s.getDestination()%></td>
                <td><%=s.getAirline()%></td>
            </tr>
            <%}%> 
		
	</table>  
	
	
</body>
</html>