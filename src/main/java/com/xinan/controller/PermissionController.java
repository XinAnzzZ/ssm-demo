package com.xinan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 18:31
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @GetMapping("/role/configuration")
    public String roleConfigurationPage() {
        return "/user/roleConfig";
    }
}
