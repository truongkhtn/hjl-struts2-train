package com.company.travel.dao.impl;

import com.company.travel.dao.UserDao;
import com.company.travel.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User,String> implements UserDao {

    public boolean isExistByUsername(String username) {
        String hql = "from User user where lower(user.username) = lower(?)";
		User user = (User) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		if (user != null) {
			return true;
		} else {
			return false;
		}
    }

    public User getUserByUsername(String username) {
        String hql = "from User user where lower(user.username) = lower(?)";
        return (User)getSession().createQuery(hql).setParameter(0, username).uniqueResult();
    }

    public List getUserList() {
        String hql = "from User user";
        return getSession().createQuery(hql).list();
    }

    public List<User> getAllNotAdmin() {
       String hql = "from User user where user.admin = false";
        return getSession().createQuery(hql).list();
    }

}
