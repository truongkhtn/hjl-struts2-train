package com.company.travel.dao;


import com.company.travel.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User, String> {

    /**
     * 根据用户名判断此用户是否存在（不区分大小写）
     */
    public boolean isExistByUsername(String username);

    /**
     * 根据用户名获取管理员对象，若管理员不存在，则返回null（不区分大小写）
     */
    public User getUserByUsername(String username);

    public List getUserList();

    List<User> getAllNotAdmin();

}
