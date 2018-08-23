package com.xinan.controller;

import com.xinan.common.consts.RoleConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 18:31
 */
@Slf4j
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @RequiresRoles(RoleConst.ADMIN)
    @GetMapping("/role/configuration")
    public String roleConfigurationPage() {
        return "/user/roleConfig";
    }

    @RequiresRoles(RoleConst.ADMIN)
    @RequestMapping("/role/configuration/json")
    @ResponseBody
    public String roleConfigurationPageJson() {
        return "/user/roleConfig";
    }
}
