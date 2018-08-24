package com.alibaba.xinan.mapper;

import com.alibaba.xinan.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        user.setUsername("xinan");
        System.out.println(userMapper.findByEntity(null));
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

    @Test
    public void testDeleteAllByIdList() {
        List<Integer> list = new ArrayList<>();
        list.add(1110);
        list.add(155);
        list.add(29);
        userMapper.deleteAllByIdList(list);
    }
}