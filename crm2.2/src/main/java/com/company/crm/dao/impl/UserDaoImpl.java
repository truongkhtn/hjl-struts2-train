package com.company.crm.dao.impl;

import com.company.crm.action.Pager;
import com.company.crm.dao.UserDao;
import com.company.crm.entity.User;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

	@SuppressWarnings("unchecked")
	public List<User> getByName(String realName) {
		Criteria criteria = getSession().createCriteria(User.class);
		if(realName!=null){
			criteria.add(Restrictions.like("realName","%"+realName+"%"));
		}
		List<User> userList=criteria.list();
		return userList;
	}

	public User login(String username, String password) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username.toLowerCase()));
		criteria.add(Restrictions.eq("password", password));
        criteria.setFetchMode("roleSet" , FetchMode.JOIN);
		User user=(User) criteria.uniqueResult();
		return user;
	}
 
	@SuppressWarnings("unchecked")
	public List<User> getByDepartmentName(String name, Pager pager) {
		Query query =null;
		String hql=null;
		if(name!=null){
			hql="form User u left join fetch u.dept where u.dept.deptName=:name";
		    query = getSession().createQuery(hql).setParameter("dept.deptName", name);	
		}else{
			hql="from User";
			 query = getSession().createQuery(hql);
		}	
        query.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
		query.setMaxResults(pager.getPageSize());
		List<User> userList=query.list();
		return userList;
	}

}
