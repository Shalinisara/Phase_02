package com.simplilearn.api.handler;

import com.simplilearn.api.UserApiController;
import com.simplilearn.persistence.UserRepository;
import com.simplilearn.persistence.entity.UserDetail;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class AuthenticationApiHandler {

    public void authenticateUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        try {
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            UserRepository userRepository = new UserRepository();
            UserDetail userDetail=userRepository.getUserByUserId(userId);
            System.out.println
            	(String.format("password=%s dbPwd=%s",
            			password,
            			userDetail.getUserpwd()));
            if(!password.equals(userDetail.getUserpwd())){
                request
                        .getRequestDispatcher(UserApiController.LOGIN_VIEW)
                        .forward(request,response);
            }else {
            	HttpSession session=request.getSession();
            	session.setAttribute("isUsedLoggedin", "true");
            	session.setAttribute("userId", userId);
            	request
                .getRequestDispatcher(UserApiController.DASHBOARD_VIEW)
                .forward(request,response);
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        	//This needs to be changed back to ERROR_VIEW. using SEACH_VIEW for test
            request
                    .getRequestDispatcher(UserApiController.SEARCH_VIEW)
                    .forward(request,response);
        }
    }
}
