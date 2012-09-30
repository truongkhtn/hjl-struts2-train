package com.company.crm.dao;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.entity.User;

public interface UserDao extends BaseDao<User, String>{
	
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
	User login(String username, String password);
	/**
	 * 根据部门名称查找部门员工
	 * @param name
	 * @return
	 */
	List<User> getByDepartmentName(String name, Pager pager);
}
