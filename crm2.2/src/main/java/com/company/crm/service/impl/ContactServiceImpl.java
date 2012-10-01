package com.company.crm.service.impl;

import com.company.crm.dao.ContactDao;
import com.company.crm.entity.Contact;
import com.company.crm.service.ContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact, String>
		implements ContactService {
	@Resource
	private ContactDao contactDao;
	
	@Resource
	public void setBaseDao(ContactDao contactDao) {
		super.setBaseDao(contactDao);
	}
	
	
	public List<Contact> getByCustomerId(String id) {
		return contactDao.getByCustomerId(id);
	}

    public Contact getMajorByCustomerId(String id) {
        return contactDao.getMajorByCustomerId(id);
    }

}
