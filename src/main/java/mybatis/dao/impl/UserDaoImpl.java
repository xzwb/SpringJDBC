package mybatis.dao.impl;

import mybatis.dao.UserDao;
import mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public List<User> findAll() {
        SqlSession session = sqlSessionFactory.openSession();
        // 调用sqlSession中的方法
        List<User> users = session.selectList("mybatis.dao.UserDao.findAll"); // 此处的参数是能获取到配置信息的key
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("mybatis.dao.UserDao.saveUser", user);
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public User findOne(Integer id) {
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public int findTotal() {
        return 0;
    }
}
