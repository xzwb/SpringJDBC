package com.xzwb.test;

import com.xzwb.mapper.UserMapper;
import com.xzwb.pojo.User;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        SqlSession session = SqlSessionFactoryBuild.openSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setName("yyf");
//        user.setAddress("1111");
        userMapper.insertUser(user);
        session.commit();
        session.close();
    }
}
