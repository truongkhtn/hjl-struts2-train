package com.company.crm.service;

import com.company.crm.entity.Contact;

import java.util.List;

public interface ContactService extends BaseService<Contact, String>{
	
	/**
	 * 根据公司id查找联系人
	 * @param id
	 * @return
	 */
	List<Contact> getByCustomerId(String id);
	
}
