package com.company.crm.service.impl;

import com.company.crm.action.Pager;
import com.company.crm.dao.UserDao;
import com.company.crm.entity.User;
import com.company.crm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements
        UserService {
	@Resource
	private UserDao userDao;
	@Resource
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}
	
	
	public List<User> getByName(String realName) {		
		return userDao.getByName(realName);
	}

	
	public User getByLogin(String username, String password) {
		return userDao.getByLogin(username, password);
	}

	
	public List<User> getByDepsrtmentName(String name, Pager pager) {
		return userDao.getByDepsrtmentName(name, pager);
	}

}
