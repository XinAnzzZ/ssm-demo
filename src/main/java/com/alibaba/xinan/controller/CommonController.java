package com.alibaba.xinan.controller;

import com.alibaba.xinan.common.enums.ResponseEnum;
import com.alibaba.xinan.common.util.ResponseJson;
import com.alibaba.xinan.entity.User;
import com.alibaba.xinan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author XinAnzzZ
 * @date 2018/8/13 11:13
 */
@Slf4j
@Controller
public class CommonController {

    @Autowired
    private UserService userService;

    /**
     * 404
     */
    @RequestMapping("/not/found")
    public String to404() {
        return "common/404";
    }

    /**
     * unauthorized
     */
    @RequestMapping("/common/unauthorized")
    public String unauthorizedPage() {
        return "/common/unauthorized";
    }

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
    @ResponseBody
    public ResponseJson userRegister(@RequestBody User user) {
        // 表单校验 ...
        return userService.register(user);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "common/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseJson login(@RequestBody User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            if (subject.isAuthenticated()) {
                subject.logout();
            }
            subject.login(token);
            return ResponseJson.success();
        } catch (UnknownAccountException e) {
            return ResponseJson.fail(ResponseEnum.UNKNOWN_ACCOUNT);
        } catch (AuthenticationException e) {
            return ResponseJson.fail(ResponseEnum.INCORRECT_CREDENTIAL);
        }
    }

    /**
     * 首页
     */
    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "/user/index";
    }
}
