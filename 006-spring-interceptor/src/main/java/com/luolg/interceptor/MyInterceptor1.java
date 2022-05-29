package com.luolg.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class MyInterceptor1 implements HandlerInterceptor {
    // before the handle the target method
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle 111 ...");
        String param = request.getParameter("param");
        System.out.println(param);
        if ("yes".equals(param)) {
            return true;
        } else {
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            return false;
        }
    }


    // after target method executed, before the view returned
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 111 .....");
        modelAndView.addObject("name","february");
    }


    // after the view returned
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 111 ....");

    }
}
