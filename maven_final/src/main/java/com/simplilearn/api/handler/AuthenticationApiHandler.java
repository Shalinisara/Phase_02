package com.simplilearn.api.handler;

import com.simplilearn.api.UserApiController;
import com.simplilearn.persistence.UserRepository;
import com.simplilearn.persistence.entity.UserDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationApiHandler {

    public void authenticateUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        try {
            String userId = request.getParameter("userid");
            String password = request.getParameter("userpwd");
            UserRepository userpwdchange = new UserRepository();
            System.out.println("user id shalini passed from method is "+userId);
            UserDetail userDetail=new UserDetail(userId,password);
            userpwdchange.updateUser(userDetail);
        } catch (Exception e) {
            request
                    .getRequestDispatcher(UserApiController.ERROR_VIEW)
                    .forward(request,response);
        }
    }
}
