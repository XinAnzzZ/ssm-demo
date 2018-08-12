package com.xinan.service.impl;

import com.xinan.entity.User;
import com.xinan.mapper.UserMapper;
import com.xinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 17:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserInfoById(Integer userId) {
        return userMapper.findById(userId);
    }
}
