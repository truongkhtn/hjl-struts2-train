package com.company.crm.service.impl;

import com.company.crm.action.Pager;
import com.company.crm.dao.ContactDao;
import com.company.crm.entity.Contact;
import com.company.crm.entity.Customer;
import com.company.crm.entity.User;
import com.company.crm.service.ContactService;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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

    public Pager getByPager(Pager pager, Contact contact) {
        return contactDao.getByPager(pager, contact);
    }

    public Pager getServeByUser(Pager pager, User owner) {
        DetachedCriteria dc = DetachedCriteria.forClass(Contact.class);
        dc.add(Restrictions.eq("major", true));//设置主联系人
        DetachedCriteria criteriaCustomer = dc.createCriteria("customer");
        criteriaCustomer.add(Restrictions.eq("status" , Customer.Status.SIGNED));//设置客户状态
        criteriaCustomer.add(Restrictions.eq("owner" , owner));//设置客户专员
        return  contactDao.findByPager(pager,dc);
    }

}
