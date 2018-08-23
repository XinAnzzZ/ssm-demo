package com.xinan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 18:36
 */
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 5688490641346673852L;

    private Integer id;

    private Integer userId;

    private Role role;

    public UserRole() {
    }

    public UserRole(Integer id) {
        this.id = id;
    }

    public UserRole(Integer userId, Role role) {
        this.userId = userId;
        this.role = role;
    }
}
