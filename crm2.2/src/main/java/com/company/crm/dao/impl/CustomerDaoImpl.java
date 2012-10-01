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
		if(customer.getMajorContact().getName()!=null){
			System.out.println("name:"+customer.getMajorContact().getName());
			if(!customer.getMajorContact().getName().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.name", customer.getMajorContact().getName()));
			}
		}
		if(customer.getMajorContact().getMobilePhone()!=null){
			if(!customer.getMajorContact().getMobilePhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.mobilePhone", customer.getMajorContact().getMobilePhone()));
			}
		}
		if(customer.getMajorContact().getPhone()!=null){
			if(!customer.getMajorContact().getPhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.phone", customer.getMajorContact().getPhone()));
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
		if(customer.getOwner()!=null){
			if(customer.getOwner().getRealName()!=null){
				criteria.add(Restrictions.eq("user.realName", customer.getOwner().getRealName()));
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
		if(customer.getMajorContact().getName()!=null){
			if(!customer.getMajorContact().getName().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.name", customer.getMajorContact().getName()));
			}
		}
		if(customer.getMajorContact().getMobilePhone()!=null){
			if(!customer.getMajorContact().getMobilePhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.mobilePhone", customer.getMajorContact().getMobilePhone()));
			}
		}
		if(customer.getMajorContact().getPhone()!=null){
			if(!customer.getMajorContact().getPhone().trim().equals("")){
				criteria.add(Restrictions.eq("contractor.phone", customer.getMajorContact().getPhone()));
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
		if(customer.getOwner()!=null){
			if(customer.getOwner().getRealName()!=null){
				criteria.add(Restrictions.eq("user.realName", customer.getOwner().getRealName()));
			}
		}
		criteria.setProjection(Projections.rowCount());
		int totle=Integer.valueOf(String.valueOf(criteria.uniqueResult()));
		return totle;
	}

}
