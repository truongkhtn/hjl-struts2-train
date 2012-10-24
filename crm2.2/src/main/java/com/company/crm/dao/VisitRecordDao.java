package com.company.crm.dao;

import com.company.crm.action.Pager;
import com.company.crm.entity.VisitRecord;

import java.util.List;

/**
 * 拜访记录
 * @author sheep
 *
 */
public interface VisitRecordDao extends BaseDao<VisitRecord, String>{
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
