package com.company.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.company.crm.action.Pager;
import com.company.crm.dao.VisitRecordDao;
import com.company.crm.entity.VisitRecord;
import com.company.crm.service.VisitRecordService;
import org.springframework.stereotype.Service;


@Service
public class VisitRecordServiceImpl extends
		BaseServiceImpl<VisitRecord, String> implements VisitRecordService {
	@Resource
	private VisitRecordDao visitRecordDao;
	@Resource
	public void setBaseDao(VisitRecordDao visitRecordDao) {
		super.setBaseDao(visitRecordDao);
	}
	
	public List<VisitRecord> get(VisitRecord visitRecord,Pager pager) {
		return visitRecordDao.get(visitRecord, pager);
	}

	public int getCount(VisitRecord visitRecord) {
		return visitRecordDao.getCount(visitRecord);
	}

}
