package com.company.travel.dao.impl;

import com.company.travel.dao.UserDao;
import com.company.travel.entity.Role;
import com.company.travel.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"JpaQlInspection"})
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

    public List<Role> getRoleListByUser(String userId) {
        User user = get(userId);
        Set<Role> roleSet = user.getRoleSet();
        List<Role> roleList = new ArrayList<Role>();
        for(Role role : roleSet){
            roleList.add(role);
        }
        return roleList;
    }

    public User getUserByUsernameAndArea(String username, String area) {
        String hql = "from User user where lower(user.username) = lower(?) and lower(user.area) = lower(?)";
        return (User) getSession().createQuery(hql).setParameter(0,username).setParameter(1,area).uniqueResult();
    }

    public List<User> getDisabledUserList() {
        String hql = "from User user where user.isAccountEnabled =?";
        return getSession().createQuery(hql).setParameter(0 , false).list();
    }

    public List getEnabledUserList() {
        String hql = "from User user where user.isAccountEnabled =?";
        return getSession().createQuery(hql).setParameter(0 , true).list();
    }
}
