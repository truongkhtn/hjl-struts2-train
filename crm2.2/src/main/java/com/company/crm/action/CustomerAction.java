package com.company.crm.action;

import com.company.crm.entity.Contact;
import com.company.crm.entity.Customer;
import com.company.crm.entity.User;
import com.company.crm.entity.VisitRecord;
import com.company.crm.service.ContactService;
import com.company.crm.service.CustomerService;
import com.company.crm.service.UserService;
import com.company.crm.service.VisitRecordService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private VisitRecordService visitRecordService;

    private Customer customer;
    private Contact contact;
    private Pager pager;
    private List<VisitRecord> visitRecordList;

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
        pager = contactService.getByPager(pager, contact);
        return SUCCESS;
    }

    public String info(){
        customer = customerService.get(id);
        Contact contact = contactService.getMajorByCustomerId(id);
        customer.setMajorContact(contact);
        return SUCCESS;
    }

    public String visitRecordList(){
        visitRecordList = visitRecordService.getList("customer.id", id);
        return SUCCESS;
    }

    //getter & setter
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
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
    public List<VisitRecord> getVisitRecordList() {
        return visitRecordList;
    }
    public void setVisitRecordList(List<VisitRecord> visitRecordList) {
        this.visitRecordList = visitRecordList;
    }
}
