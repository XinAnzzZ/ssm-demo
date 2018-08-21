package com.xinan.mapper;

import com.xinan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 16:40
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * find by username   这个注释是idea自动生成的，这个地方应该写上这个方法的
     * 使用说明，方法的作用等等
     *
     * @param username the username  这个是对方法的参数进行解释说明
     * @return the user   对返回值进行解释说明   如果没有返回值  删掉这一行
     */
    User findByUsername(@Param("username") String username);
}
