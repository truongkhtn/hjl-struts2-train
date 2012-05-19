package com.company.travel.service;

import com.company.travel.entity.User;
import java.util.List;

public interface UserService extends BaseService<User, String> {

    public User getUserByUsername(String username);

    public String changePassword(String oldPassword, String newPassword);

    public void logoutPrincipal();

    public User getUserSessionInfo();

    public List<User> getDisabledUserList();

    public List getEnabledUserList();
}
