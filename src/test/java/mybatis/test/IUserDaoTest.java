package mybatis.test;

import mybatis.dao.UserAnnotationDao;
import mybatis.dao.impl.IUserDaoImpl;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IUserDaoTest {
    public static void main(String[] args) throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3.试用工厂创建dao对象
        IUserDaoImpl userDao = new IUserDaoImpl(factory);
        // 5.使用代理对象执行方法
        List<User> list = userDao.findAll();
        System.out.println(list);
        // 6.释放资源
        in.close();
    }
}
