package com.xinan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 17:03
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8775492676889532979L;

    private Integer id;

    private String username;

    private String password;
}
