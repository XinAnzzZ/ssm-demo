package com.xinan.controller;

import com.xinan.entity.User;
import com.xinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 17:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户id获取用户信息
     */
    @ResponseBody
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Integer userId) {
        return userService.getUserInfoById(userId);
    }
}
