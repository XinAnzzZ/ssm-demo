package com.alibaba.xinan.mapper;

import com.alibaba.xinan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 16:40
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * find by username
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(@Param("username") String username);

    /**
     * delete all by user id list
     *
     * @param userIdList the user id list
     */
    void deleteAllByIdList(@Param("userIdList") List<Integer> userIdList);
}
