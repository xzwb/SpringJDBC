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
import java.util.Date;
import java.util.List;

public class MybatisTest1 {
    @Test
    public void save() throws IOException {
        User user = new User();
        user.setSex("男");
        user.setAddress("南门小区");
        user.setUsername("杨一凡");
        user.setBirthday(new Date());
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        // 获取dao代理对象
        UserDao dao = sqlSession.getMapper(UserDao.class);
        // 执行保存
        dao.saveUser(user);
        sqlSession.commit();
        in.close();
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        User user = new User();
        user.setId(6);
        user.setSex("man");
        user.setAddress("南123小区");
        user.setUsername("杨一凡");
        user.setBirthday(new Date());
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        // 获取dao代理对象
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.updateUser(user);
        sqlSession.commit();
        in.close();
        sqlSession.close();
    }

    @Test
    public void delete() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        // 获取dao代理对象
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.delete(6);
        sqlSession.commit();
        in.close();
        sqlSession.close();
    }

    @Test
    public void findOne() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        // 获取dao代理对象
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = dao.findOne(7);
        System.out.println(user);
        in.close();
        sqlSession.close();
    }

    @Test
    /**
     * 测试模糊查询
     */
    public void findByName() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        // 获取dao代理对象
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.findByName("杨一凡");
        System.out.println(users);
        in.close();
        sqlSession.close();
    }

    @Test
    public void findTotal() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        // 获取dao代理对象
        UserDao dao = sqlSession.getMapper(UserDao.class);
        int total = dao.findTotal();
        System.out.println(total);
        in.close();
        sqlSession.close();
    }
}
