package cn.com.oceansoft.struts2.service;

import cn.com.oceansoft.struts2.entity.User;

import java.util.List;

/**
 * User service 接口类
 *
 * @author 胡荆陵
 */
public interface UserService {

    void save(User user);

    void update(User user);

    void delete(String userId);

    User getById(String userId);

    User getByName(String name);

    List<User> getAll();

    int countAll();

    void deleteAll();

    List<User> getActiveUserByNameLike(User user);

    List<User> getActiveUserLike(User user);

    List<User> getUserLike(User user);

    List<User> getByIds(List<String> selectedIds);

}
