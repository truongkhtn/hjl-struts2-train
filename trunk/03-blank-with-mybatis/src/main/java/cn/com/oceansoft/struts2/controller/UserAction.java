package cn.com.oceansoft.struts2.controller;

import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * User Action 类
 *
 * @author 胡荆陵
 */
@Component
public class UserAction extends BaseAction {

    private List<User> userList;
    private User user;

    @Resource
    private UserService userService;

    public String initCreateUser(){
        user = null;
        return SUCCESS;
    }

    public String createUser(){
        userService.save(user);
        return SUCCESS;
    }

    public String viewUser(){
        User u = userService.getById(id);
        this.user = u;
        return SUCCESS;
    }

    public String initUpdateUser(){
        User u = userService.getById(id);
        this.user = u;
        return SUCCESS;
    }

    public String updateUser(){
        User u = userService.getById(id);
        u.setName(user.getName());
        userService.update(u);
        return SUCCESS;
    }

    public String deleteUser(){
        userService.delete(id);
        return SUCCESS;
    }

    public String getAll() {
        userList = userService.getAll();
        return SUCCESS;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
