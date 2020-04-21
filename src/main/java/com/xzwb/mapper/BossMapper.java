package com.xzwb.mapper;

import com.xzwb.pojo.Boss;

import java.util.List;

public interface BossMapper {
    void insertBoss(Boss boss);

    List<Boss> selectBoss();
}
