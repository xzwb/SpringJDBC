package mybatis.dao;

import mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    /**
     * 保存方法
     * @param user
     */
    void saveUser(User user);

    /**
     * 跟新用户
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     */
    void delete(Integer id);

    /**
     * 根据id查
     */
    User findOne(Integer id);

    /**
     * 根据名字模糊查询
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     */
    int findTotal();

    /**
     * 根据传入参数条件查询
     */
    List<User> findByCondition(User user);

    /**
     * 传入集合
     */
    List<User> findByIntegerList(List<Integer> list);
}
