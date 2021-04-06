package com.simplilearn.api;

import com.simplilearn.persistence.FlightsRepository;
import com.simplilearn.persistence.entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class GetFlight
 */
@WebServlet("/flight")
public class FlightApiController extends HttpServlet {


	public static final String REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION="REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION";
	public static final String VIEW_FLIGHTS="flightshow.jsp";
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		List<Flight> flights =  new FlightsRepository().searchFlightsBySourceAndDestination(source, destination);
		flights.stream().forEach(System.out::println);
		HttpSession session = request.getSession();
	    request.setAttribute(REQ_ATTR_FLIGHTS_DATA_BY_SOURCE_DESTINATION,flights);
		request
				.getRequestDispatcher(VIEW_FLIGHTS)
				.forward(request,response);
	}

	

}
