package com.company.crm.dao.impl;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.dao.VisitRecordDao;
import com.company.crm.entity.VisitRecord;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class VisitRecordDaoImpl extends BaseDaoImpl<VisitRecord, String> implements
        VisitRecordDao {

	@SuppressWarnings("unchecked")
	public List<VisitRecord> get(VisitRecord visitRecord, Pager pager) {
		Criteria criteria = getSession().createCriteria(VisitRecord.class).setFetchMode("visitType",FetchMode.JOIN).setFetchMode("customer",FetchMode.JOIN);
		if(visitRecord.getVisitType().getValue()!=null || !"==请选择==".equals(visitRecord.getVisitType().getValue())){
			criteria.add(Restrictions.eq("visitType.name", visitRecord.getVisitType().getValue()));
		}
		
		criteria.add(Restrictions.eq("isFirstVisit",visitRecord.isFirstVisit()));
		
		if(visitRecord.getOwner().getRealName()!=null){
			criteria.add(Restrictions.eq("user.realName", visitRecord.getOwner().getRealName()));
		}
		if(visitRecord.getCustomer().getLevel()!=null || !"==请选择==".equals(visitRecord.getCustomer().getLevel())){
			criteria.add(Restrictions.eq("customer.level",visitRecord.getCustomer().getLevel()));
		}

		criteria.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
		criteria.setMaxResults(pager.getPageSize());
		List<VisitRecord> visitRecordList=criteria.list();
		return visitRecordList;
	}

	public int getCount(VisitRecord visitRecord) {
		Criteria criteria = getSession().createCriteria(VisitRecord.class).setFetchMode("visitType",FetchMode.JOIN).setFetchMode("customer",FetchMode.JOIN);
		if(visitRecord.getVisitType().getValue()!=null || !"==请选择==".equals(visitRecord.getVisitType().getValue())){
			criteria.add(Restrictions.eq("visitType.name", visitRecord.getVisitType().getValue()));
		}
		
		criteria.add(Restrictions.eq("isFirstVisit",visitRecord.isFirstVisit()));
		
		if(visitRecord.getOwner().getRealName()!=null){
			criteria.add(Restrictions.eq("user.realName", visitRecord.getOwner().getRealName()));
		}
		if(visitRecord.getCustomer().getLevel()!=null || !"==请选择==".equals(visitRecord.getCustomer().getLevel())){
			criteria.add(Restrictions.eq("customer.level",visitRecord.getCustomer().getLevel()));
		}
		criteria.setProjection(Projections.rowCount());
		int totle=Integer.valueOf(String.valueOf(criteria.uniqueResult()));
		return totle;
	}

}
