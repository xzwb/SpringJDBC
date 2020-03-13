package mybatisAnnotation.dao;

import mybatisAnnotation.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select *from user")
    List<User> findAll();

    @Select("select *from user where id=#{id}")
    User findById(Integer id);
}
