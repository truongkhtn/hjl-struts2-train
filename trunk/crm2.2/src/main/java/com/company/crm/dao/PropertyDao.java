package com.company.crm.dao;

import java.util.List;

import com.company.crm.entity.Property;

public interface PropertyDao extends BaseDao<Property, String>{
	/**
	 * 根据模版id查找该模版的所有自定义属性
	 * @param id
	 * @return
	 */
	List<Property> getByContractTemplateDaoId(int id);

}
