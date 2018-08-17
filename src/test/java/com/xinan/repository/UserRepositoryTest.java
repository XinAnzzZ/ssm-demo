package com.xinan.repository;

import com.xinan.entity.jpa.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author XinAnzzZ
 * @date 2018/8/17 15:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void fun() {
        Optional<User> byId = userRepository.findById(1);
        System.out.println(byId);
    }
}