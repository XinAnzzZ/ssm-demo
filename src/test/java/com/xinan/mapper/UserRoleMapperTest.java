package com.xinan.mapper;

import com.xinan.entity.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 19:17
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    public void findByUserId() {
        List<UserRole> byUserId = userRoleMapper.findByUserId(1);
        System.out.println(byUserId);
    }
}