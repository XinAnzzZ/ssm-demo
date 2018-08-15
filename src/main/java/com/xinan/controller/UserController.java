package com.xinan.controller;

import com.xinan.common.util.ResponseJson;
import com.xinan.entity.User;
import com.xinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 注册页面
     */
    @GetMapping("/register")
    public String register() {
        return "common/register";
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public ResponseJson userRegister(@RequestBody User user) {
        // 表单校验 ...
        return userService.register(user);
    }

    /**
     * 首页
     */
    @GetMapping("/index")
    public String index() {
        return "/user/index";
    }

    /**
     * 根据用户id获取用户信息
     */
    @ResponseBody
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Integer userId) {
        return userService.getUserInfoById(userId);
    }

    @RequestMapping("/404")
    public String to404() {
        return "common/404";
    }
}
