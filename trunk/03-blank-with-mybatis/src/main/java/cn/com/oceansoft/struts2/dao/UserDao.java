package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    void update(User user);

    void delete(String userId);

    User getById(String userId);

    List<User> getAll();

    int countAll();



}
