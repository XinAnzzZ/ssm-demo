package com.xinan.controller;

import com.xinan.enums.ResponseEnum;
import com.xinan.util.ResponseJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XinAnzzZ
 * @date 2018/8/13 11:13
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseJson login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseJson.success();
        } catch (UnknownAccountException e) {
            return ResponseJson.fail(ResponseEnum.UNKNOWN_ACCOUNT);
        }
    }
}
