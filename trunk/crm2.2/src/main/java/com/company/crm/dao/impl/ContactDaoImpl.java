package com.company.crm.dao.impl;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.dao.ContactDao;
import com.company.crm.entity.Contact;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class ContactDaoImpl extends BaseDaoImpl<Contact, String> implements ContactDao {

	public List<Contact> getByCustomerId(String id) {
		String hql="from Contact c where c.customer.id=:id order by c.major desc";
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
