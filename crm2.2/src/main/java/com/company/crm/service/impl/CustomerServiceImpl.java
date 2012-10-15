package com.company.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.company.crm.action.Pager;
import com.company.crm.dao.ContactDao;
import com.company.crm.dao.CustomerDao;
import com.company.crm.entity.Contact;
import com.company.crm.entity.Customer;
import com.company.crm.service.ContactService;
import com.company.crm.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, String>
		implements CustomerService {
	@Resource
	private CustomerDao customerDao;
    @Resource
    private ContactDao contactDao;

	@Resource
	public void setBaseDao(CustomerDao customerDao) {
		super.setBaseDao(customerDao);
	}
	
	public List<Customer> get(Customer customer,
			Pager pager) {
		return customerDao.get(customer, pager);
	}

	public int getCount(Customer customer) {
		return customerDao.getCount(customer);
	}

    public void saveLinkedContact(Customer customer) {
        //设置初始状态: 未签约客户
        customer.setStatus(Customer.Status.UNSIGNED);
        customerDao.save(customer);
        //设置初始状态: 是主联系人
        Contact majorContact = customer.getMajorContact();
        majorContact.setMajor(true);
        majorContact.setCustomer(customer);
        contactDao.save(majorContact);
    }


}
