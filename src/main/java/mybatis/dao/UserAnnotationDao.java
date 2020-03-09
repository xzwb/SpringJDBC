package mybatis.dao;


import mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserAnnotationDao {
    @Select("select *from user")
    List<User> findAll();
}
