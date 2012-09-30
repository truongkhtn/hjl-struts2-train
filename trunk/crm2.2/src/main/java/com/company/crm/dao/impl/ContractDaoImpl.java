package com.company.crm.dao.impl;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.dao.ContractDao;
import com.company.crm.entity.Contract;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract, String> implements ContractDao {

	@SuppressWarnings("unchecked")
	public List<Contract> get(Contract contract, Pager pager) {
		Criteria criteria = getSession().createCriteria(Contract.class).setFetchMode("contractTemplate", FetchMode.JOIN).setFetchMode("signUser", FetchMode.JOIN);
		if(contract.getcName()!=null){
			criteria.add(Restrictions.eq("cName",contract.getcName()));
		}
		if(contract.getcNumber()!=null){
			criteria.add(Restrictions.eq("cNumber",contract.getcNumber()));
		}
		if(contract.getContractTemplate().getName()!=null){
			criteria.add(Restrictions.eq("contractTemplate.name", contract.getContractTemplate().getName()));
		}
		if(contract.getSignUser().getRealName()!=null){
			criteria.add(Restrictions.eq("signUser.realName", contract.getSignUser().getRealName()));
		}
        criteria.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
		criteria.setMaxResults(pager.getPageSize());
		List<Contract> contractList=criteria.list();
		return contractList;
	}

	public Contract getByNum(String contractNum) {
		Criteria criteria = getSession().createCriteria(Contract.class);
		criteria.add(Restrictions.eq("cNumber", contractNum));
		Contract contract=(Contract) criteria.uniqueResult();
		return contract;
	}

	public int getCount(Contract contract) {
		Criteria criteria = getSession().createCriteria(Contract.class).setFetchMode("contractTemplate", FetchMode.JOIN).setFetchMode("signUser", FetchMode.JOIN);
		if(contract.getcName()!=null){
			criteria.add(Restrictions.eq("cName",contract.getcName()));
		}
		if(contract.getcNumber()!=null){
			criteria.add(Restrictions.eq("cNumber",contract.getcNumber()));
		}
		if(contract.getContractTemplate().getName()!=null){
			criteria.add(Restrictions.eq("contractTemplate.name", contract.getContractTemplate().getName()));
		}
		if(contract.getSignUser().getRealName()!=null){
			criteria.add(Restrictions.eq("signUser.realName", contract.getSignUser().getRealName()));
		}
		criteria.setProjection(Projections.rowCount());
		int totle=Integer.valueOf(String.valueOf(criteria.uniqueResult()));
		return totle;
	}


}
