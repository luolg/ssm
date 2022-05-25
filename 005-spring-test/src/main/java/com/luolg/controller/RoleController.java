package com.luolg.controller;

import com.luolg.domain.Role;
import com.luolg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        System.out.println(roleList);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet() {
        return "role-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(Role role) {
//        String roleName = request.getParameter("roleName");
//        String roleDesc = request.getParameter("roleDesc");
//        System.out.println(roleName + " " + roleDesc);

        int row = roleService.addRole(role);
        System.out.println(row);
        if (row == 1) {
            return "redirect:/role/list";
        }
        return "fail";
    }


}
