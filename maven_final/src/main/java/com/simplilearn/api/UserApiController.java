package com.simplilearn.api;

import com.simplilearn.api.handler.AuthenticationApiHandler;
import com.simplilearn.api.handler.UpdateUserApiHandler;
import com.simplilearn.common.UserAction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class UserApiController extends jakarta.servlet.http.HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR_VIEW="./error/error.jsp";
	public static final String LOGIN_VIEW="./index.jsp";
	public static final String DASHBOARD_VIEW="./dashboard/dashboard.jsp";
	public static final String SEARCH_VIEW="./search/searchFlights.jsp";

	private AuthenticationApiHandler authenticationApiHandler;
	private UpdateUserApiHandler updateUserApiHandler;

	public UserApiController(){
		this.authenticationApiHandler= new AuthenticationApiHandler();
		this.updateUserApiHandler = new UpdateUserApiHandler();
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(String.format("Action=%s ", action));
		try
		{
			switch (UserAction.valueOf(action)){
				case AUTH:
					authenticationApiHandler.authenticateUser(request,response);
					break;
				case UPDATE:
					updateUserApiHandler.updateUser(request,response);
					break;
				case LOGOUT:
					request.getSession().invalidate();
					request
						.getRequestDispatcher(LOGIN_VIEW)
						.forward(request,response);
					break;
				default:
					request
							.getRequestDispatcher(SEARCH_VIEW)
							.forward(request,response);
			}
		}catch(Exception e){
			throw new RuntimeException("Error while processing request",e);
		}

	}

}
