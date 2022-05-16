package com.luolg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luolg.domain.User;
import com.luolg.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username",})
@RequestMapping(value = "/quick")

public class UserController {


    @RequestMapping(value = "/user")
    public String save() {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user?username=jack
        System.out.println("UserController save running ...");
        return "success";
    }

    @RequestMapping(value = "/user2")
    public ModelAndView save2() {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user2?username=jack
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "rose");

        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/user3")
    public ModelAndView save3(ModelAndView modelAndView) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user3?username=jack
        modelAndView.addObject("username", "jack");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/user4")
    public String save4(Model model) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user4?username=jack
        model.addAttribute("username", "kobe");
        return "success";
    }

    @RequestMapping(value = "/user5")
    public String save5(HttpServletRequest httpServletRequest) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user5?username=jack
        httpServletRequest.setAttribute("username", "jordan");
        return "success";
    }

    @RequestMapping(value = "/user6")
    public void save6(HttpServletResponse httpServletResponse) throws IOException {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user6?username=jack
        httpServletResponse.getWriter().print("hello my homie");
    }


    @RequestMapping(value = "/user7")
    @ResponseBody // tell spring not related to view
    public String save7() {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user7?username=jack
        return "hello my bro";
    }

    @RequestMapping(value = "/user8")
    @ResponseBody // tell spring not related to view
    public String save8() {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user8?username=jack
        return "{\"msg\":\"hello my bro\"}";
    }

    @RequestMapping(value = "/user9")
    @ResponseBody // tell spring not related to view
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lebron");
        user.setAge(30);
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user9?username=jack
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }


    @RequestMapping(value = "/user10")
    @ResponseBody // tell spring not related to view

    public User save10() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lebron");
        user.setAge(33);
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user10?username=jack
        return user;
    }

    // accept the param
    @RequestMapping(value = "/user11")
    @ResponseBody
    public void save11(String username, int age) {
        // accept the params from parameter
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user11?username=jack&age=11
        System.out.println(username);
        System.out.println(age);
    }

    // accept the para and init the User object
    @RequestMapping(value = "/user12")
    @ResponseBody
    public void save12(User user) {
        //        POJO way
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user12?username=jack&age=11
        System.out.println(user);
    }

    // accept the array
    @RequestMapping(value = "/user13")
    @ResponseBody
    public void save13(String[] strs) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user13?username=jack&strs=aaa&strs=bbb&strs=ccc
        System.out.println(Arrays.asList(strs));
    }

    // package userList to Vo
    @RequestMapping(value = "/user14")
    @ResponseBody
    public void save14(VO vo) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/form.jsp
        System.out.println(vo);
    }

    // test ajax with Collection of userList
    @RequestMapping(value = "/user15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/ajax.jsp
        System.out.println(userList);
    }

    // test RequestParam
    @RequestMapping(value = "/user16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "jordan") String username) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user16?name=jack
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user16
        System.out.println(username);
    }

    // test the pathVariable
    @RequestMapping(value = "/user17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username", required = true) String name) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user17/jack
        System.out.println(name);
    }

    // test self defined converter
    @RequestMapping(value = "/user18")
    @ResponseBody
    public void save18(Date date) {
        //  self defined      http://localhost:8080/003_ssm_mvc_war_exploded/quick/user18?date=2022-6-6
        //  self defined      http://localhost:8080/003_ssm_mvc_war_exploded/quick/user18?date=2022-11-16
        //  normal      http://localhost:8080/003_ssm_mvc_war_exploded/quick/user18?date=2022/11/11

        System.out.println(date);
    }

    // get the raw servlet info maintained by tomcat
    @RequestMapping(value = "/user19")
    @ResponseBody
    public void save19(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user19
        System.out.println(req);
        System.out.println(req);
        System.out.println(session);
    }

    // get the request header
    @RequestMapping(value = "/user20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user20
        System.out.println(userAgent);
    }


    // get the cookie value
    @RequestMapping(value = "/user21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID", required = false) String jSessionId) {
        //        http://localhost:8080/003_ssm_mvc_war_exploded/quick/user21
        System.out.println(jSessionId);
    }

    // file upload
    @RequestMapping(value = "/user22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile, MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        System.out.println(uploadFile2);
        //        http://localhost:8080/003_ssm_mvc_war_exploded/upload.jsp
        String originalFilename = uploadFile.getOriginalFilename();
        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile.transferTo(new File("C:\\upload\\" + originalFilename));
        uploadFile2.transferTo(new File("C:\\upload\\" + originalFilename2));
    }


    // file several upload
    @RequestMapping(value = "/user23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        //        http://localhost:8080/003_ssm_mvc_war_exploded/upload.jsp
        for (MultipartFile multipartFile : uploadFile) {
            System.out.println(multipartFile);
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\upload\\" + originalFilename));
        }
    }


}
