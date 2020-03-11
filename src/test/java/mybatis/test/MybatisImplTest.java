package mybatis.test;

import mybatis.dao.impl.UserDaoImpl;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisImplTest {
    @Test
    public void findAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        List<User> users = new UserDaoImpl(sqlSessionFactory).findAll();
        System.out.println(users);
        in.close();
    }

    @Test
    public void save() throws IOException {
        User user = new User();
        user.setBirthday(new Date());
        user.setUsername("fff");
        user.setSex("nv");
        user.setAddress("aaaa");
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        new UserDaoImpl(sqlSessionFactory).saveUser(user);
        in.close();
    }
}
