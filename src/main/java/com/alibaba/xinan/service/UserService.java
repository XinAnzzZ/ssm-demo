package com.alibaba.xinan.service;

import com.alibaba.xinan.common.util.ResponseJson;
import com.alibaba.xinan.entity.User;

import java.util.List;

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

    /**
     * register
     *
     * @param user the user
     * @return the response
     */
    ResponseJson register(User user);

    /**
     * get all user
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @param order      the order
     * @return user list
     */
    ResponseJson getAllUser(int pageNumber, int pageSize, String order);

    /**
     * 批量删除用户
     *
     * @param userList the user list
     * @return the response
     */
    ResponseJson deleteUser(List<User> userList);
}
