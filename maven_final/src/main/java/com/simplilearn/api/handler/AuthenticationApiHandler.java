package com.simplilearn.api.handler;

import com.simplilearn.api.UserApiController;
import com.simplilearn.persistence.UserRepository;
import com.simplilearn.persistence.entity.UserDetail;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class AuthenticationApiHandler {

    public void authenticateUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        try {
            String userId = request.getParameter("userid");
            String password = request.getParameter("userpwd");
            UserRepository userRepository = new UserRepository();
            UserDetail userDetail=userRepository.getUserByUserId(userId);
            if(!password.equals(userDetail.getUserpwd())){
                request
                        .getRequestDispatcher(UserApiController.LOGIN_VIEW)
                        .forward(request,response);
            }
            request
                    .getRequestDispatcher(UserApiController.DASHBOARD_VIEW)
                    .forward(request,response);
        } catch (Exception e) {
        	e.printStackTrace();
            request
                    .getRequestDispatcher(UserApiController.ERROR_VIEW)
                    .forward(request,response);
        }
    }
}
