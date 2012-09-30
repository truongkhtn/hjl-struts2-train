package com.company.crm.dao;

import java.util.List;

import com.company.crm.entity.Contact;

/**
 * 联系人
 * @author sheep
 *
 */
public interface ContactorDao extends BaseDao<Contact, String>{
	
	/**
	 * 根据公司Id查找联系人
	 * @param id
	 * @return
	 */
	List<Contact> getByCustomerId(String id);
}