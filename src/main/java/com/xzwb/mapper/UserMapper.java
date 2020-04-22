package com.xzwb.mapper;

import com.xzwb.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void insertUser(User user);
    void insertUser1(@Param("user") User user,
                     @Param("id") int id);
}
