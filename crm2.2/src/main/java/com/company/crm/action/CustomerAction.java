package com.company.crm.action;

import com.company.crm.entity.Contact;
import com.company.crm.entity.User;
import com.company.crm.service.ContactService;
import com.company.crm.service.CustomerService;
import com.company.crm.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Common Action 类，包含系统普通操作
 *
 * @author 胡荆陵
 */
@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction {

    @Resource
    private CustomerService customerService;
    @Resource
    private ContactService contactService;

    private Contact contact;
    private Pager pager;

    public String blank() {
        return SUCCESS;
    }

    public void validateConflict(){
        int condition = 0;
        if(StringUtils.isNotEmpty(contact.getName())){
           condition++;
        }
        if(StringUtils.isNotEmpty(contact.getPhone())){
           condition++;
        }
        if(StringUtils.isNotEmpty(contact.getEmail())){
           condition++;
        }
        if(StringUtils.isNotEmpty(contact.getCustomer().getName())){
           condition++;
        }
        if(StringUtils.isNotEmpty(contact.getCustomer().getAddress())){
           condition++;
        }
        if(condition == 0){
            addActionError("查询条件不能为空!至少一个条件");
        }
    }

    public String conflict() {
        System.out.println("conflict run...");
        pager = contactService.getByPager(pager, contact);
        return SUCCESS;
    }

    //getter & setter
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public Pager getPager() {
        return pager;
    }
    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
