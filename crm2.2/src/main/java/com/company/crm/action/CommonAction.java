package com.company.crm.action;

import com.company.crm.entity.User;
import com.company.crm.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Common Action 类，包含系统普通操作
 *
 * @author 胡荆陵
 */
@Controller
public class CommonAction extends BaseAction {

    @Resource
    private UserService userService;

    private User user;

    public String index() {
        return SUCCESS;
    }

    public String login(){
        User temp = userService.getByLogin(user.getUsername() , user.getPassword());
        if(temp != null){
            ServletActionContext.getRequest().getSession().setAttribute(LOGIN_USER, temp);
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public String logout(){
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }

    //getter & setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
