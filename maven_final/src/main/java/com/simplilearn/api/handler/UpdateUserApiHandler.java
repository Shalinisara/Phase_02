package com.simplilearn.api.handler;

import com.simplilearn.api.UserApiController;
import com.simplilearn.persistence.UserRepository;
import com.simplilearn.persistence.entity.UserDetail;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdateUserApiHandler {

    public void updateUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        try {
            String userId = request.getParameter("userid");
            String password = request.getParameter("userpwd");
            UserRepository userRepository = new UserRepository();
            UserDetail userDetail=new UserDetail(userId,password);
            userRepository.updateUser(userDetail);
        } catch (Exception e) {
            request
                    .getRequestDispatcher(UserApiController.ERROR_VIEW)
                    .forward(request,response);
        }
    }
}
