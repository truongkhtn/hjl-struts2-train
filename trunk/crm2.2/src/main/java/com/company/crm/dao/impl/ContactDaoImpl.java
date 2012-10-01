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

    public Pager getByPager(Pager pager, Contact contact) {
        if(pager == null){
            pager = new Pager();
        }
        Criteria criteria = getSession().createCriteria(Contact.class);
        criteria.add(Restrictions.eq("major" , true));

        if(StringUtils.isNotEmpty(contact.getPhone().trim())){
            criteria.add(Restrictions.like("phone" , "%"+contact.getPhone().trim()+"%"));
        }
        if(StringUtils.isNotEmpty(contact.getMobilePhone().trim())){
            criteria.add(Restrictions.like("mobilePhone" , "%"+contact.getMobilePhone().trim()+"%"));
        }
        if(StringUtils.isNotEmpty(contact.getName().trim())){
            criteria.add(Restrictions.like("name" , "%"+contact.getName().trim()+"%"));
        }
        if(contact.getCustomer()!=null){
            Criteria criteriaCustomer = criteria.createCriteria("customer");
            if(StringUtils.isNotEmpty(contact.getCustomer().getName().trim())){
                criteriaCustomer.add(Restrictions.like("name" , "%"+contact.getCustomer().getName().trim()+"%"));
            }
            if(StringUtils.isNotEmpty(contact.getCustomer().getAddress().trim())){
                criteriaCustomer.add(Restrictions.like("address" , "%"+contact.getCustomer().getAddress().trim()+"%"));
            }
        }
        //total
        criteria.setProjection(Projections.rowCount());
        long lTotal = (Long)criteria.uniqueResult();
        pager.setTotalCount(Integer.valueOf(String.valueOf(lTotal)));

        //pager
        criteria.setProjection(null);
        criteria.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
		criteria.setMaxResults(pager.getPageSize());
        pager.setList(criteria.list());
        return pager;
    }

}
