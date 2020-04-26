package springMybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springMybatis.mapper.UserMapper;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springMybatis.xml");
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        System.out.println(userMapper.selectUser());
    }
}
