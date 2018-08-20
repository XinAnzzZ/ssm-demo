package com.xinan.mapper;

import com.xinan.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 11:41
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findById() {
        User user = new User();
        user.setUsername("testUsername");
        user.setPassword("testPassword");
        userMapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("testUpdateUsername");
        userMapper.update(user);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(2);
    }
}