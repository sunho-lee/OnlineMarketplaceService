package com.project.onlinemarketplaceservice.interceptor;

import com.project.onlinemarketplaceservice.annotation.LoginCheck;
import com.project.onlinemarketplaceservice.constants.SessionLoginConstant;
import com.project.onlinemarketplaceservice.exception.UnAuthenticatedAccessException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {

        HttpSession session = request.getSession();
        String loginId = (String) session.getAttribute(SessionLoginConstant.LOGIN_ID);
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (handlerMethod.hasMethodAnnotation(LoginCheck.class) && loginId == null) {
            throw new UnAuthenticatedAccessException("인가되지 않은 접근입니다.");
        }

        return true;
    }
}
