package com.luolg.controller;

import com.luolg.exception.MyException;
import com.luolg.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/show1")
    public String show1() {
        System.out.println("trigger error");
        demoService.show1();
        return "index";
    }

    @RequestMapping(value = "/show2")
    public String show2() {
        System.out.println("trigger error");
        demoService.show2();
        return "index";
    }

    @RequestMapping(value = "/show3")
    public String show3() throws FileNotFoundException {
        System.out.println("trigger error");
        demoService.show3();
        return "index";
    }

    @RequestMapping(value = "/show4")
    public String show4() {
        System.out.println("trigger error");
        demoService.show4();
        return "index";
    }


    @RequestMapping(value = "/show5")
    public String show5() throws MyException {
        System.out.println("trigger self defined error");
        demoService.show5();
        return "index";
    }

}
