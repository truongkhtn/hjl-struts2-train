package com.company.travel.service;

import com.company.travel.entity.User;
import java.util.List;

/**
 * UserService 接口类
 */
public interface UserService extends BaseService<User, String> {

    public User getUserByUsername(String username);

    public String changePassword(String oldPassword, String newPassword);

    public List getUserList();

    public boolean login(User user);
}
