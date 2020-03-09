package mybatis.dao.impl;

import mybatis.dao.IUserDao;
import mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class IUserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        // 1.使用工厂创建SQLSession对象
        SqlSession session = factory.openSession();
        // 2.使用session执行查询
        List<User> users =  session.selectList("mybatis.dao.IUserDao.findAll");
        // 3. 关闭资源
        session.close();

        return users;
    }
}
