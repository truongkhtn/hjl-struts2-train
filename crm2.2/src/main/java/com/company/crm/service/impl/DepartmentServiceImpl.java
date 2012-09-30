package com.company.crm.service.impl;


import com.company.crm.dao.DepartmentDao;
import com.company.crm.entity.Department;
import com.company.crm.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, String>
		implements DepartmentService {

	@Resource
	public void setBaseDao(DepartmentDao departmentDao) {
		super.setBaseDao(departmentDao);
	}

}
