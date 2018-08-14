package com.xinan.mapper;

import com.xinan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 16:40
 */
@Mapper
public interface UserMapper {

    /**
     * find by id
     *
     * @param userId user id
     * @return user
     */
    User findById(@Param("userId") Integer userId);

    /**
     * find by username
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(@Param("username") String username);
}
