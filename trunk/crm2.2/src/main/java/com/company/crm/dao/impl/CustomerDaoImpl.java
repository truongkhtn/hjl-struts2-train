package com.company.crm.dao.impl;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.dao.CustomerDao;
import com.company.crm.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer, String> implements
        CustomerDao {

	@SuppressWarnings("unchecked")
	public List<Customer> get(Customer customer, Pager pager) {
		Criteria criteria = getSession().createCriteria(Customer.class).setFetchMode("contractor",FetchMode.JOIN).setFetchMode("user",FetchMode.JOIN);
		if(customer.getName()!=null ){
			if(!customer.getName().trim().equals("")){
				criteria.add(Restrictions.eq("name", customer.getName()));
			}
		}
		if(customer.getAddress()!=null){
			if(!customer.getAddress().trim().equals("")){
				criteria.add(Restrictions.eq("address", customer.getAddress()));
			}
		}
		if(customer.getContact().getName()!=null){
			System.out.println("name:"+customer.getContact().getName());
			if(!customer.getContact().getName().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.name", customer.getContact().getName()));
			}
		}
		if(customer.getContact().getMobilePhone()!=null){
			if(!customer.getContact().getMobilePhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.mobilePhone", customer.getContact().getMobilePhone()));
			}
		}
		if(customer.getContact().getPhone()!=null){
			if(!customer.getContact().getPhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.phone", customer.getContact().getPhone()));
			}
		}
		if(customer.getSource()!=null || !"==请选择==".equals(customer.getSource())){
			criteria.add(Restrictions.eq("source", customer.getSource()));
		}
		if(customer.getLevel()!=null || !"==请选择==".equals(customer.getLevel())){
			criteria.add(Restrictions.eq("level", customer.getLevel()));
		}
		if(customer.getStatus()!=null){
			criteria.add(Restrictions.eq("status", customer.getStatus()));
		}
		if(customer.getUser()!=null){
			if(customer.getUser().getRealName()!=null){
				criteria.add(Restrictions.eq("user.realName", customer.getUser().getRealName()));
			}
		}
        criteria.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
		criteria.setMaxResults(pager.getPageSize());
		List<Customer> customerList=criteria.list();
		return customerList;
	}

	public int getCount(Customer customer) {
		Criteria criteria = getSession().createCriteria(Customer.class).setFetchMode("contractor",FetchMode.JOIN).setFetchMode("user",FetchMode.JOIN);
		if(customer.getName()!=null ){
			if(!customer.getName().trim().equals("")){
				criteria.add(Restrictions.eq("name", customer.getName()));
			}
		}
		if(customer.getAddress()!=null){
			if(!customer.getAddress().trim().equals("")){
				criteria.add(Restrictions.eq("address", customer.getAddress()));
			}
		}
		if(customer.getContact().getName()!=null){
			if(!customer.getContact().getName().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.name", customer.getContact().getName()));
			}
		}
		if(customer.getContact().getMobilePhone()!=null){
			if(!customer.getContact().getMobilePhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.mobilePhone", customer.getContact().getMobilePhone()));
			}
		}
		if(customer.getContact().getPhone()!=null){
			if(!customer.getContact().getPhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.phone", customer.getContact().getPhone()));
			}
		}
		if(customer.getSource()!=null || !"==请选择==".equals(customer.getSource())){
			criteria.add(Restrictions.eq("source", customer.getSource()));
		}
		if(customer.getLevel()!=null || !"==请选择==".equals(customer.getLevel())){
			criteria.add(Restrictions.eq("level", customer.getLevel()));
		}
		if(customer.getStatus()!=null){
			criteria.add(Restrictions.eq("status", customer.getStatus()));
		}
		if(customer.getUser()!=null){
			if(customer.getUser().getRealName()!=null){
				criteria.add(Restrictions.eq("user.realName", customer.getUser().getRealName()));
			}
		}
		criteria.setProjection(Projections.rowCount());
		int totle=Integer.valueOf(String.valueOf(criteria.uniqueResult()));
		return totle;
	}

}
