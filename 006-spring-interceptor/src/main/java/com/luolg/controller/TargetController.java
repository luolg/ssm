package com.luolg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {

    @RequestMapping(value = "/target")
    public ModelAndView show() {
        System.out.println("target resource executing ...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "january");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
