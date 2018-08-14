package com.xinan.service;

import com.xinan.entity.User;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 17:05
 */
public interface UserService {

    /**
     * get user info
     *
     * @param userId user id
     * @return User
     */
    User getUserInfoById(Integer userId);

    /**
     * get user info
     *
     * @param username the username
     * @return user info
     */
    User getUserInfoByUsername(String username);
}
