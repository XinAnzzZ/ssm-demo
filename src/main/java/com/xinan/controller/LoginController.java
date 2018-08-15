package com.xinan.controller;

import com.xinan.common.enums.ResponseEnum;
import com.xinan.common.util.ResponseJson;
import com.xinan.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XinAnzzZ
 * @date 2018/8/13 11:13
 */
@Controller
public class LoginController {

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
}
