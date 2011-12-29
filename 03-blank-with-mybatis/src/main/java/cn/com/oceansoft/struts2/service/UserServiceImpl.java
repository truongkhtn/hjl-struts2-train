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
        if (user.getBirthday() == null) {
            user.setBirthday(new Date());
        }
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

    @Transactional
    public void testTx() {
        User user1 = new User(UuidUtil.genUuid(),"111",new Date());
        userDao.save(user1);

        User user2 = new User(UuidUtil.genUuid(),"222",new Date());
        userDao.save(user2);

        User user3 = new User(UuidUtil.genUuid(),"333",new Date());
        userDao.save(user3);

        User user4 = new User(UuidUtil.genUuid(),"444",new Date());
        userDao.save(user4);
        throw new RuntimeException("throw a test RuntimeException...");
    }
}
