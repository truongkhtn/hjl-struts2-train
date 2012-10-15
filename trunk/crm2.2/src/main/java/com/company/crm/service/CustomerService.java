package com.company.crm.service;

import com.company.crm.action.Pager;
import com.company.crm.entity.Customer;

import java.util.List;


public interface CustomerService extends BaseService<Customer, String>{
	
	/**
	 * 根据业务员的填写来查询公海中是否有相关的客户
	 * @param customer
	 * @return
	 */
	List<Customer> get(Customer customer, Pager pager);
	/**
	 * 根据业务员的填写来查询相关的客户数量
	 * @param customer
	 * @return
	 */
	int getCount(Customer customer);

    public void saveLinkedContact(Customer customer);
}
