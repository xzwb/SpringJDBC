package com.xzwb.test;

import com.xzwb.mapper.BossMapper;
import com.xzwb.pojo.Boss;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class BossMapperTest {
    public static void main(String[] args) {
        SqlSession session = SqlSessionFactoryBuild.openSqlSession();
        BossMapper bossMapper = session.getMapper(BossMapper.class);
//        Boss boss = new Boss();
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        boss.setCar(list);
//        boss.setName("yyf");
//        bossMapper.insertBoss(boss);
        System.out.println(bossMapper.selectBoss());
        session.commit();
        session.close();
    }
}
