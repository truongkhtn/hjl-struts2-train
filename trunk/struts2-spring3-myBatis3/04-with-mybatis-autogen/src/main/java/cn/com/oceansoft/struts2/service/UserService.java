package cn.com.oceansoft.struts2.service;

import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.entity.UserExample;

import java.util.List;

/**
 * User service 接口实现类
 *
 * @author 胡荆陵
 */
public interface UserService {

    void save(User user);

    void update(User user);

    void delete(String userId);

    User getById(String userId);

    User getByExample(UserExample userExample);

    List<User> getAll();

    int countAll();

}
