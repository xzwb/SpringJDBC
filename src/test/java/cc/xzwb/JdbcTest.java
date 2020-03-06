package cc.xzwb;

import cc.xzwb.config.JdbcConfig;
import cc.xzwb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JdbcConfig.class)
public class JdbcTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    /**
     * 插入操作 赠删改都这个
     */
    public void test() {
        jdbcTemplate.update("insert into t_user values('杨一凡', 1)");
    }

    @Test
    /**
     * 查询
     */
    public void test1() {
        String name = jdbcTemplate.queryForObject("select name from t_user where id = ?", String.class, 1);
        System.out.println(name);
    }

    @Test
    public void test2() {
        User user = jdbcTemplate.queryForObject("select *from t_user where id = 1", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setId(resultSet.getInt("id"));
                return user;
            }
        });
        System.out.println(user);
    }
}
