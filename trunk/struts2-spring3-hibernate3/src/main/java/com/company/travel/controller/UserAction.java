package com.company.travel.controller;

import com.company.travel.entity.User;
import com.company.travel.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User Action 类，包含对于所有 User 对象的操作
 *
 * @author 胡荆陵
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction {

    private static final Logger log = Logger.getLogger(UserAction.class);

    //spring 注入
    @Resource
    private UserService userService;

    //action 属性
    private User user;
    private List userList;
    private String oldPass;
    private String newPass;

    public String blank() {
        return SUCCESS;
    }

    public String login() {
        if (user == null) {
            return INPUT;
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            return INPUT;
        }
        User u = userService.getUserByUsername(user.getUsername());
        if (u == null) {
            return INPUT;
        } else {
            if (u.getPassword().toLowerCase().equals(user.getPassword().trim().toLowerCase())
                    && u.isAdmin()) {
                this.setSession(LOGIN_USER, u);
                return SUCCESS;
            } else {
                return INPUT;
            }
        }
    }

    public String logout(){
        this.getSession().clear();
//        this.getSession().remove(LOGIN_USER);
        return SUCCESS;
    }

    public String changePass() {
        log.debug("changePass run ...");
        String tempPass = getLoginUser().getPassword();
        if (!tempPass.equals(oldPass)) {
            addFieldError("oldPass", "原密码不正确!");
            oldPass = "";
            newPass = "";
            return INPUT;
        }
        if (StringUtils.isEmpty(newPass)) {
            addFieldError("newPass", "新密码不能为空!");
            oldPass = "";
            newPass = "";
            return INPUT;
        }
        User user = getLoginUser();
        user.setPassword(newPass);
        userService.update(user);
        log.debug("changePass end ...");
        return SUCCESS;
    }

    public String enable() {
//        User user = userService.get(id);
//        user.setIsAccountEnabled(true);
//        Set<Role> set = new HashSet<Role>();
//        Role role = roleService.get("roleUser");
//        set.add(role);
//        user.setRoleSet(set);
//        userService.update(user);
        return SUCCESS;
    }

    public String deleteDisabled() {
        userService.delete(id);
        return SUCCESS;
    }

    public String userList() {
        userList = userService.getUserList();
        return SUCCESS;
    }

    public String deleteEnabled() {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(getText("error.data.linked"));
            return INPUT;
        }
        return SUCCESS;
    }

    public String view() {
        user = userService.get(id);
        return SUCCESS;
    }

    public String initUpdate() {
        user = userService.get(id);
        return SUCCESS;
    }

    public String update() {
//        User oldUser = userService.get(user.getId());
//        oldUser.setCompanyName(user.getCompanyName());
//        oldUser.setCompanyAddress(user.getCompanyAddress());
//        oldUser.setName(user.getName());
//        oldUser.setPhone(user.getPhone());
//        oldUser.setFax(user.getFax());
//        oldUser.setCellPhone(user.getCellPhone());
//        userService.update(oldUser);
        return SUCCESS;
    }

    //getter & setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }
}
