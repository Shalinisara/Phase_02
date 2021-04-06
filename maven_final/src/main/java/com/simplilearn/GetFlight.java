package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.maven_hibernate.FetchOperationsUsingHQL;
import com.simplilearn.maven_hibernate.Learners;

/**
 * Servlet implementation class GetFlight
 */
public class GetFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String src = request.getParameter("source");
		String dest = request.getParameter("destination");
		PrintWriter out = response.getWriter();
		//out.println(src);
		//out.println(dest);
		

		 List<Flights> theflight =  new Fetchflights().getflightbyplace(src, dest);
		 
		for(Flights tempflights : theflight) 
		{
		 out.println(tempflights.airline);
		 PrintWriter printWriter = response.getWriter();
	        printWriter.println(tempflights.airline);
		  }
		HttpSession session = request.getSession();
	    request.setAttribute("tempflights",theflight);
		
		response.sendRedirect("flightshow.jsp");
		
	}

	

}
