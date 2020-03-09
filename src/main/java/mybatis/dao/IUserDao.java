package mybatis.dao;

import mybatis.pojo.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
