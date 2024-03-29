package com.company.crm.service;

import com.company.crm.action.Pager;
import com.company.crm.entity.User;

import java.util.List;

public interface UserService extends BaseService<User, String>{
	
	/**
	 * 根据员工姓名查找员工详细信息
	 * @param realName
	 * @return
	 */
	List<User> getByName(String realName);
	
	/**
	 * 根据 username ,password查找用户
	 * @param username,password
	 * @return
	 */
	User getByLogin(String username, String password);
	/**
	 * 根据部门名称查找部门员工
	 * @param name
	 * @return
	 */
	List<User> getByDepartmentName(String name, Pager pager);
}
