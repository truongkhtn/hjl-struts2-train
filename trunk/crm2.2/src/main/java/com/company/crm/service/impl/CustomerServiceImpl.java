package com.company.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.company.crm.action.Pager;
import com.company.crm.dao.CustomerDao;
import com.company.crm.entity.Customer;
import com.company.crm.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, String>
		implements CustomerService {
	@Resource
	private CustomerDao customerDao;
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


}
