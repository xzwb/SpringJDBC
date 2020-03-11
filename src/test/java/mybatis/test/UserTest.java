package mybatis.test;

import mybatis.dao.UserDao;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    @Test
    public void test() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        System.out.println(users);
        session.close();
        in.close();
    }
}
