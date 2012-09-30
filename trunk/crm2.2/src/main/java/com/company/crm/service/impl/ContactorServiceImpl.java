package com.company.crm.service.impl;

import com.company.crm.dao.ContactorDao;
import com.company.crm.entity.Contact;
import com.company.crm.service.ContactorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactorServiceImpl extends BaseServiceImpl<Contact, String>
		implements ContactorService {
	@Resource
	private ContactorDao contractorDao;
	
	@Resource
	public void setBaseDao(ContactorDao contractorDao) {
		super.setBaseDao(contractorDao);
	}
	
	
	public List<Contact> getByCustomerId(String id) {
		return contractorDao.getByCustomerId(id);
	}

}
