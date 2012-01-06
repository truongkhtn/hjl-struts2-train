package cn.com.oceansoft.struts2.service;

import cn.com.oceansoft.struts2.dao.UserDao;
import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.utils.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * User service 接口实现类
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

    public User getByName(String name) {
        return userDao.getByName(name);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public int countAll() {
        return userDao.countAll();
    }

    public void deleteAll() {
        userDao.deleteAll();
    }

    public List<User> getActiveUserByNameLike(User user) {
        return userDao.getActiveUserByNameLike(user);
    }

    public List<User> getActiveUserLike(User user) {
        return userDao.getActiveUserLike(user);
    }

    public List<User> getUserLike(User user) {
        return userDao.getUserLike(user);
    }

    public List<User> getByIds(List<String> selectedIds) {
        return userDao.getByIds(selectedIds);
    }

}
