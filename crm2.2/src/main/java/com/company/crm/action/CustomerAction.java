package com.company.crm.action;

import com.company.crm.entity.Contact;
import com.company.crm.entity.Customer;
import com.company.crm.entity.VisitRecord;
import com.company.crm.service.ContactService;
import com.company.crm.service.CustomerService;
import com.company.crm.service.VisitRecordService;
import com.company.crm.utils.Gender;
import com.company.crm.utils.Level;
import org.apache.commons.lang3.StringUtils;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    private List<Contact> contactList;
    private Map<String,String> sourceMap;
    private Map<String,String> levelMap;
    private Map<String,String> titleMap;

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
        pager = visitRecordService.getByPager(id, pager);
        return SUCCESS;
    }

    public String contactList(){
        contactList = contactService.getByCustomerId(id);
        return SUCCESS;
    }

    public String initAdd(){
        Customer.Source[] sources = Customer.Source.values();
        Level[] levels = Level.values();
        Contact.Title[] titles = Contact.Title.values();
        //init data
        sourceMap = new LinkedHashMap<String,String>();
        for(Customer.Source s : sources){
            sourceMap.put(s.toString(), getText("Source." + s.toString()));
        }
        levelMap = new LinkedHashMap<String,String>();
        for(Level l : levels){
            levelMap.put(l.toString(), getText("Level." + l.toString()));
        }
        titleMap = new LinkedHashMap<String,String>();
        for(Contact.Title t : titles){
            titleMap.put(t.toString(), getText("Title." + t.toString()));
        }

        //init test data
        DataFactory dataFactory = new DataFactory();
        customer = new Customer();
        customer.setAddress(dataFactory.getAddress());
        customer.setAddress2(dataFactory.getAddress());
        customer.setBusiness(dataFactory.getRandomWord().toUpperCase());
        customer.setFax(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
        customer.setLevel(levels[dataFactory.getNumberBetween(0, levels.length - 1)]);
        customer.setName("CUSTOMER_" + dataFactory.getRandomWord().toUpperCase());
        customer.setRemark(dataFactory.getRandomText(20, 30));
        customer.setSource(sources[dataFactory.getNumberBetween(0, sources.length - 1)]);
        customer.setWebSite("www."+dataFactory.getRandomWord().toLowerCase()+".com");

        contact = new Contact();
        contact.setCustomer(customer);
        contact.setEmail(dataFactory.getEmailAddress());
        contact.setGender(dataFactory.chance(70) ? Gender.MALE : Gender.FEMALE);
        contact.setMobilePhone(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
        contact.setName(dataFactory.getName());
        contact.setPhone(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
        contact.setTitle(titles[dataFactory.getNumberBetween(0,titles.length-1)]);
        contact.setQq(String.valueOf(dataFactory.getNumberBetween(100000,999999)));
        contact.setRemark(dataFactory.getRandomText(10, 30));

        return SUCCESS;
    }

    public String add(){
        customer.setOwner(getLoginUser());
        customer.setMajorContact(contact);
        customerService.saveLinkedContact(customer);
        return SUCCESS;
    }

    //getter & setter
    public Map<String, String> getTitleMap() {
        return titleMap;
    }

    public void setTitleMap(Map<String, String> titleMap) {
        this.titleMap = titleMap;
    }

    public Map<String, String> getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(Map<String, String> levelMap) {
        this.levelMap = levelMap;
    }

    public Map<String, String> getSourceMap() {
        return sourceMap;
    }

    public void setSourceMap(Map<String, String> sourceMap) {
        this.sourceMap = sourceMap;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

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
