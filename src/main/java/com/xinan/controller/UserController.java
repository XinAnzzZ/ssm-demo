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
     * 根据用户id获取用户信息
     */
    @ResponseBody
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Integer userId) {
        return userService.getUserInfoById(userId);
    }

    /**
     * 列表页
     */
    @GetMapping("/list")
    public String listPage() {
        return "/user/list";
    }

    /**
     * 用户列表
     */
    @GetMapping("/list/data")
    @ResponseBody
    public ResponseJson getListData() {
        return userService.getAllUser();
    }

    /**
     * 保存用户111
     */
    @PostMapping("")
    @ResponseBody
    public ResponseJson saveUser(@RequestBody User user) {
        return userService.register(user);
    }
}
