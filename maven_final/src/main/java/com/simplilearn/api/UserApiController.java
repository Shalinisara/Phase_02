package com.simplilearn.api;

import com.simplilearn.api.handler.AuthenticationApiHandler;
import com.simplilearn.api.handler.UpdateUserApiHandler;
import com.simplilearn.common.UserAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/user")
public class UserApiController extends HttpServlet {

	public static final String ERROR_VIEW="/error/error.jsp";
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try
		{
			switch (UserAction.valueOf(action)){
				case AUTH:
					authenticationApiHandler.authenticateUser(request,response);
				case UPDATE:
					updateUserApiHandler.updateUser(request,response);
				default:
					request
							.getRequestDispatcher(ERROR_VIEW)
							.forward(request,response);
			}
		}catch(Exception e){
			throw new RuntimeException("Error while processing request",e);
		}

	}

}
