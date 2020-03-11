package mybatis.test;

import mybatis.dao.AccountDao;
import mybatis.pojo.Account;
import mybatis.pojo.AccountAndUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    @Test
    public void findAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
        session.close();
        in.close();
    }

    @Test
    public void find() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<AccountAndUser> list = accountDao.find();
        System.out.println(list);
        session.close();
        in.close();
    }
}
