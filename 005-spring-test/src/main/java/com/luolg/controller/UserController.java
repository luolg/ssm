package com.luolg.controller;

import com.luolg.domain.Role;
import com.luolg.domain.User;
import com.luolg.service.RoleService;
import com.luolg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.list();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addGet() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(User user, Long[] roleIds) {
        for (Long roleId : roleIds) {
            System.out.println("selectede role id: " + roleId);
        }
        userService.addUser(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete/{userId}")
    public String delete(@PathVariable("userId") Long userId) {
        userService.delete(userId);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            // login succeed, storage user to session
            System.out.println("controller info: " + user);
            session.setAttribute("user", user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

}
