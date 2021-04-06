package com.simplilearn.api;

import com.simplilearn.persistence.FlightsRepository;
import com.simplilearn.persistence.entity.Flight;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class GetFlight
 */
public class FlightApiController extends jakarta.servlet.http.HttpServlet {


	public static final String REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION="REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION";
	public static final String VIEW_FLIGHTS="../dashboard/dashboard.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightApiController() {
        super();
    }

	/**
	 * Accepts source and destination and returns the matching flights to Flights View
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		System.out.println(String.format("source=%s, destination=%s", source,destination));
		List<Flight> flights =  new FlightsRepository().searchFlightsBySourceAndDestination(source, destination);
		flights.stream().forEach(System.out::println);
		request.setAttribute("source", source);
		request.setAttribute("destination", destination);
	    request.setAttribute(REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION,flights);
		request
				.getRequestDispatcher(VIEW_FLIGHTS)
				.forward(request,response);
	}

	

}
