package cn.com.oceansoft.struts2.service;

import cn.com.oceansoft.struts2.dao.UserDao;
import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.entity.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User service 接口类
 *
 * @author 胡荆陵
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(String userId) {
        userDao.delete(userId);
    }

    public User getById(String userId) {
        return userDao.getById(userId);
    }

    public User getByExample(UserExample userExample) {
        return userDao.getByExample(userExample);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public int countAll() {
        return userDao.countAll();
    }
}
