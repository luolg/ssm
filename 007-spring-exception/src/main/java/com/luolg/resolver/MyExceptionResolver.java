package com.luolg.resolver;

import com.luolg.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof MyException) {
            modelAndView.addObject("info", "self defined exception");
        } else if (ex instanceof ClassCastException) {
            modelAndView.addObject("info", "found cast exception form javalang");
        }
        modelAndView.setViewName("resolver-error");
        return modelAndView;
    }
}
