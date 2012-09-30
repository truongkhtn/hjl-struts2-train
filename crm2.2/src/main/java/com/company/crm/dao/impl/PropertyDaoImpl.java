package com.company.crm.dao.impl;

import com.company.crm.dao.PropertyDao;
import com.company.crm.entity.Property;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertyDaoImpl extends BaseDaoImpl<Property, String> implements PropertyDao {

	@SuppressWarnings("unchecked")
	public List<Property> getByContractTemplateDaoId(int id) {
		String hql="form Property p left join fetch p.contractTemplate where p.contractTemplate.id=:id";
		Query query=getSession().createQuery(hql).setParameter("contractTemplate.id", id);
		List<Property> propertyList=query.list();
		return propertyList;
	}


}
