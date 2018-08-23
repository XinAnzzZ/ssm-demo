package com.xinan.service.impl;

import com.xinan.common.enums.RoleEnum;
import com.xinan.common.util.ResponseJson;
import com.xinan.common.util.ShiroUtils;
import com.xinan.entity.Role;
import com.xinan.entity.User;
import com.xinan.entity.UserRole;
import com.xinan.mapper.UserMapper;
import com.xinan.mapper.UserRoleMapper;
import com.xinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 17:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User getUserInfoById(Integer userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User getUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ResponseJson register(User user) {
        user.setPassword(ShiroUtils.toMD5(user.getPassword(), user.getUsername()));
        userMapper.save(user);
        UserRole userRole = new UserRole(user.getId(), new Role(RoleEnum.USER.getCode()));
        userRoleMapper.save(userRole);
        return ResponseJson.success();
    }

    @Override
    public ResponseJson getAllUser() {
        return ResponseJson.success(userMapper.findByEntity(null));
    }
}
