package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Set the content type
		response.setContentType("text/html");
		
//		Get the writer
		PrintWriter out = response.getWriter();
		
		//		Fetch the values from Request
		String userName = request.getParameter("userName");
//		String userPassword = request.getParameter("userPass");
		
//		Get a reference to the Session
		HttpSession theSession = request.getSession();
		
//		Check whether parameters exists in the request
		if(userName !=  null) {
//			Save the userName(coming from the request) into the session
			theSession.setAttribute("uName", userName);
			
		}
		
//		Print userName from request
		out.println("Welcome " + userName + "<br>");
		
//		Print userName from session
		out.println("Welcome " + theSession.getAttribute("uName"));
	}

}
