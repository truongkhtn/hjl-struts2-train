package com.company.travel.service.impl;

import com.company.travel.dao.UserDao;
import com.company.travel.entity.User;
import com.company.travel.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService 接口实现类
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

    @Resource
    public void setBaseDao(UserDao userDao) {
        super.setBaseDao(userDao);
    }

    @Resource
    private UserDao userDao;

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public String changePassword(String oldPassword, String newPassword) {
        String username = "unknown";
        String flg = "OK";
//        username = SecurityContextHolder.getContext().getAuthentication().getName();
//        if (!username.equals("unknown")) {
//            try {
//                User user = userDao.getUserByUsername(username);
//                if (user != null && user.getPassword().equals(oldPassword)) {
//                    user.setPassword(newPassword);
//                    userDao.update(user);
//                } else {
//                    flg = "旧密码不正确";
//                }
//            } catch (Exception e) {
//                flg = "密码修改失败，请与管理员联系!";
//            }
//        }
        return flg;
    }

    public List getUserList() {
        return userDao.getUserList();
    }

    public boolean login(User user) {
        User u = getUserByUsername(user.getUsername());
        if(u == null){
                return false;
        }else{
            if(u.getPassword().toLowerCase().equals(user.getPassword().trim().toLowerCase())){
                return true;
            }else{
                return false;
            }
        }
    }

}
