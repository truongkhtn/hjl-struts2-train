package com.company.crm.action;

import com.company.crm.entity.User;
import com.company.crm.service.CustomerService;
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
public class CustomerAction extends BaseAction {

    @Resource
    private CustomerService customerService;

    public String blank() {
        return SUCCESS;
    }

    public String conflict() {
        System.out.println("conflict run...");
        return SUCCESS;
    }

}
