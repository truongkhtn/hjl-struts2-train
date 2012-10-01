package com.company.crm.service;

import com.company.crm.action.Pager;
import com.company.crm.entity.Contact;

import java.util.List;

public interface ContactService extends BaseService<Contact, String>{
	
	/**
	 * 根据公司id查找联系人
	 * @param id
	 * @return
	 */
	List<Contact> getByCustomerId(String id);

    /**
	 * 根据公司id查找主联系人
	 * @param id
	 * @return
	 */
    Contact getMajorByCustomerId(String id);


    Pager getByPager(Pager pager, Contact contact);
}
