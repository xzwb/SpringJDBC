package mybatis.test;

import mybatis.dao.UserAnnotationDao;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnotationTest {
    public static void main(String[] args) throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 4.使用SqlSession创建Dao接口的地代理对象
        UserAnnotationDao userDao = sqlSession.getMapper(UserAnnotationDao.class);
        // 5.使用代理对象执行方法
        List<User> list = userDao.findAll();
        System.out.println(list);
        // 6.释放资源
        sqlSession.close();
        in.close();
    }
}
