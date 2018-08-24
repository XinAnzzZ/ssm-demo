package com.alibaba.xinan.controller;

import com.alibaba.xinan.common.util.ResponseJson;
import com.alibaba.xinan.entity.User;
import com.alibaba.xinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseJson getListData(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam(required = false, defaultValue = "username") String orderColumn,
                                    @RequestParam(required = false, defaultValue = "ASC") String orderType) {
        String order = orderColumn + " " + orderType;
        return userService.getAllUser(pageNum, pageSize, order);
    }

    /**
     * 保存用户
     */
    @PostMapping("")
    @ResponseBody
    public ResponseJson saveUser(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 批量删除
     */
    @DeleteMapping("")
    @ResponseBody
    public ResponseJson deleteUser(@RequestBody List<User> userList) {
        return userService.deleteUser(userList);
    }
}
