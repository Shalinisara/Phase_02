package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/changepwd")
public class changepwd extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		HttpSession session = request.getSession();
		
		
		try {
			UserpwdChange userpwdchange = new UserpwdChange();
			System.out.println("user id shalini passed from method is "+userid);
			userpwdchange.changePass(userid, userpwd);
			//response.sendRedirect("Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
