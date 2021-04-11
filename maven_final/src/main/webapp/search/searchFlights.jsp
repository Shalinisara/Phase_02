<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%

%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Search Flights</title>
    </head>
<body>
        <form action="./flight/search" method="POST">

           <label for="source">Source:</label>
           <select name="source" id="source">
             <option value="StLouis">StLouis</option>
             <option value="Madurai">Madurai</option>
           </select>

           <label for="destination">Source:</label>
           <select name="destination" id="destination">
             <option value="StLouis">StLouis</option>
             <option value="Madurai">Madurai</option>
           </select>

           <input type="submit">Search</input>
        </form>

</body>
</html>