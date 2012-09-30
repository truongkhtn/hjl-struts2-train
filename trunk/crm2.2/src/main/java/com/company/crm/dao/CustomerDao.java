package com.company.crm.dao;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.entity.Customer;

public interface CustomerDao extends BaseDao<Customer, String>{
	/**
	 * 根据业务员的填写来查询相关的客户
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

}
