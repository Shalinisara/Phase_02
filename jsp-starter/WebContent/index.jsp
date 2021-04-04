<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>
<h2><% for( int val=1; val<10; val++) 
	{ 
		out.print(val);
	}
	%></h2>
<select>
	<option>
		Please select your ID: 
	</option>

</select>
<br></br>

<select>
	<option>Please select your ID:</option>
	<%
		for(int value = 667; value <= 1249; value++){
			%>
			<option><% out.println(value); %></option>
	<%		
		}
	%>
</select>
                                 
</body>
</html>