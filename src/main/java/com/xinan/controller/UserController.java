package com.xinan.controller;

import com.xinan.entity.User;
import com.xinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 17:00
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUserInfo(@PathVariable("id") Integer userId) {
        return userService.getUserInfoById(userId);
    }

    @GetMapping("/user/login")
    public String userLoginPage() {
        return "/user/login";
    }
}
