package shiwu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shiwu.pojo.Role;
import shiwu.service.RoleListService;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("shiwu.xml");
        RoleListService roleListService = applicationContext.getBean(RoleListService.class);
        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Role role = new Role();
            role.setId(i);
            role.setRoleName(i+"yyf");
            role.setNote(i+"sss");
            roles.add(role);
        }
        System.out.println(roleListService.insertRoleList(roles));
    }
}
