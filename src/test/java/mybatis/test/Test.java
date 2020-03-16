package mybatis.test;

import mybatis.dao.User1Dao;
import mybatis.pojo.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        User1Dao user1Dao = session.getMapper(User1Dao.class);
        User1 user1 = user1Dao.findById(1);
        System.out.println(user1);
        in.close();
        session.close();
    }
}
