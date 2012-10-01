package com.company.crm.dao.impl;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.dao.ContactDao;
import com.company.crm.entity.Contact;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        criteria.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
		criteria.setMaxResults(pager.getPageSize());

        if(StringUtils.isNotEmpty(contact.getPhone())){
            criteria.add(Restrictions.like("phone" , "%"+contact.getPhone()+"%"));
        }
        if(StringUtils.isNotEmpty(contact.getMobilePhone())){
            criteria.add(Restrictions.like("mobilePhone" , "%"+contact.getMobilePhone()+"%"));
        }
        if(StringUtils.isNotEmpty(contact.getName())){
            criteria.add(Restrictions.like("name" , "%"+contact.getName()+"%"));
        }
        if(contact.getCustomer()!=null){
            Criteria criteriaCustomer = criteria.createCriteria("customer");
            if(StringUtils.isNotEmpty(contact.getCustomer().getName())){
                criteriaCustomer.add(Restrictions.like("name" , "%"+contact.getCustomer().getName()+"%"));
            }
            if(StringUtils.isNotEmpty(contact.getCustomer().getAddress())){
                criteriaCustomer.add(Restrictions.like("address" , "%"+contact.getCustomer().getAddress()+"%"));
            }
        }
        pager.setList(criteria.list());
        return pager;
    }

}
