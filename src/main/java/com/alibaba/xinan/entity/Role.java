package com.alibaba.xinan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 18:35
 */
@Data
public class Role {

    private Integer id;

    private String roleName;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }
}
