package mybatis.dao;

import mybatis.pojo.Account;
import mybatis.pojo.AccountAndUser;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有订单
     * @return
     */
    List<Account> findAll();

    /**
     * 查询多表
     * @return
     */
    List<AccountAndUser> find();
}
