package com.company.crm.dao.impl;

import java.util.List;

import com.company.crm.dao.ContactorDao;
import com.company.crm.entity.Contact;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ContractorDaoImpl extends BaseDaoImpl<Contact, String> implements ContactorDao {

	@SuppressWarnings("unchecked")
	public List<Contact> getByCustomerId(String id) {
		String hql="from Contractor c left join fetch c.customer where c.customer.id=:id";
		Query query=getSession().createQuery(hql).setParameter("id", id);
		List<Contact> contractorList=query.list();
		return contractorList;
	}

}
