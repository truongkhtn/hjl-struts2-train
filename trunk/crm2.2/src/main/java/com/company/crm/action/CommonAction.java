package com.company.crm.action;

import com.company.crm.entity.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

/**
 * Common Action 类，包含系统普通操作
 *
 * @author 胡荆陵
 */
@Controller
public class CommonAction extends BaseAction {

    private User user;

    public String index() {
        return SUCCESS;
    }

    public String login(){
        if(user.getUsername().equals("jack")
                   && user.getPassword().equals("123")){
            ServletActionContext.getRequest().getSession().setAttribute(LOGIN_USER, user);
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
