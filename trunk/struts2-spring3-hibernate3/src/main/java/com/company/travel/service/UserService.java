package com.company.travel.service;

import com.company.travel.entity.Role;
import com.company.travel.entity.User;
import java.util.List;

public interface UserService extends BaseService<User, String> {

    public User getUserByUsername(String username);

    public String changePassword(String oldPassword, String newPassword);

    public void logoutPrincipal();

    public User getUserSessionInfo();

    public List<Role> getRoleListByUser(String userId);

    public List<Role> getValidRoleListByUser(String userId);

    /**
     * 旅游预订平台特有方法，根据用户名和区域查询用户信息, 增加验证判定范围
     * @param username 用户名
     * @param area 区域
     * @return User 实例
     */
    public User getUserByUsernameAndArea(String username, String area);

    /**
     * 获取所有待开通账户的用户列表
     * @return
     */
    public List<User> getDisabledUserList();

    public List getEnabledUserList();
}
