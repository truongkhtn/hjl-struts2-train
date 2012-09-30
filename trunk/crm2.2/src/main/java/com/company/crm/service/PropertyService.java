package com.company.crm.service;

import com.company.crm.entity.Property;

import java.util.List;

public interface PropertyService extends BaseService<Property, String>{
	
	/**
	 * 根据模版id查找该模版的所有自定义属性
	 * @param id
	 * @return
	 */
	List<Property> getByContractTemplateDaoId(int id);
	
}
