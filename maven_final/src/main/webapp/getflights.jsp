<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

String src = request.getParameter("source");
String dest = request.getParameter("destination");

try{
	Fetchflights theflight= new Fetchflights();
	theflight.getflightbyplace(src,dest);
	for(flights tempflights : theflight) { System.out.println(tempflights);
	 }
}catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

%>
</body>
</html>