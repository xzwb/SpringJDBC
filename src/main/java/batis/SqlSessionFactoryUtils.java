package batis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 构建SQLSessionFactory
 */
public class SqlSessionFactoryUtils {
    /**
     * 这是一把锁
     */
    private final static Class<SqlSessionFactoryUtils> lock = null;

    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 采用单例模式 构造方法私有化
     */
    private SqlSessionFactoryUtils() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        synchronized (lock) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }
            String resource = "SqlMapConfig.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
