<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.simplilearn.persistence.entity.Flight"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

Search Results:

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