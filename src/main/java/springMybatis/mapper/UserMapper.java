package springMybatis.mapper;

import com.xzwb.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectUser();
}
