package com.company.crm.service;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.entity.VisitRecord;

public interface VisitRecordService extends BaseService<VisitRecord, String>{
	/**
	 * 根据选择查找拜访记录
	 * @param visitRecord
	 * @return
	 */
	List<VisitRecord> get(VisitRecord visitRecord, Pager pager);
	/**
	 * 根据选择查找拜访记录数量
	 * @param visitRecord
	 * @return
	 */
	int getCount(VisitRecord visitRecord);
}
