package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.User;

import java.util.List;

/**
 * User Dao 接口类
 *
 * @author 胡荆陵
 */
public interface UserDao {

    /**
     * 新增 User
     *
     * @param user {@link User}
     */
    void save(User user);

    /**
     * 更新 User
     *
     * @param user {@link User}
     */
    void update(User user);

    /**
     * 删除 User
     *
     * @param id User 主键
     */
    void delete(String id);

    /**
     * 根据 id 查询 User
     *
     * @param userId User 主键
     * @return User
     */
    User getById(String userId);

    /**
     * 根据 name 查询 User
     *
     * @return User
     */
    public User getByName(String name);

    /**
     * 查询所有 User
     *
     * @return List 用户列表
     */
    List<User> getAll();

    /**
     * 查询用户总数
     *
     * @return int  用户总数
     */
    int countAll();

}
