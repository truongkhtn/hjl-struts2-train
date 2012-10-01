package com.company.crm.dao.impl;

import java.util.List;

import com.company.crm.dao.ContactDao;
import com.company.crm.entity.Contact;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ContactDaoImpl extends BaseDaoImpl<Contact, String> implements ContactDao {

	@SuppressWarnings("unchecked")
	public List<Contact> getByCustomerId(String id) {
		String hql="from Contact c where c.customer.id=:id";
		Query query=getSession().createQuery(hql).setParameter("id", id);
		List<Contact> contractorList=query.list();
		return contractorList;
	}

    public Contact getMajorByCustomerId(String id) {
        String hql="from Contact c where c.customer.id=:id and c.major=true";
		Query query=getSession().createQuery(hql).setParameter("id", id);
        return (Contact) query.uniqueResult();
    }

}
