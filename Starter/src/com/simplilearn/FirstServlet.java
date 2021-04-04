package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "FirstServlet", urlPatterns = { "/first"}, initParams = {@WebInitParam(name = "jdbcDriver", value = "com.mysql.cj.jdbc.Driver")})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		public void init() throws ServletException {
		System.out.println("init() called...");
		}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		String username= request.getParameter("userName");
		//String userpass = request.getParameter("userPass");
		String useraddress = request.getParameter("userAddress");
		response.getWriter().println("Hello " +username+ " your address is: "+useraddress);
		//out.println("<h2>Its the HTML - DO get<h2>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
