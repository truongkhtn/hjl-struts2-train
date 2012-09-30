package com.company.crm.service.impl;


import com.company.crm.dao.BaseDao;
import com.company.crm.service.BaseService;

import java.io.Serializable;
import java.util.List;


/**
 * Service实现类 - Service实现类基类
 */

public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    private BaseDao<T, PK> baseDao;

    public BaseDao<T, PK> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<T, PK> baseDao) {
        this.baseDao = baseDao;
    }

    public T get(PK id) {
        return baseDao.get(id);
    }

    public List<T> get(PK[] ids) {
        return baseDao.get(ids);
    }

    public T get(String propertyName, Object value) {
        return baseDao.get(propertyName, value);
    }

    public List<T> getList(String propertyName, Object value) {
        return baseDao.getList(propertyName, value);
    }

    public List<T> getAll() {
        return baseDao.getAll();
    }

    public Long getTotalCount() {
        return baseDao.getTotalCount();
    }

    public boolean isExist(String propertyName, Object value) {
        return baseDao.isExist(propertyName, value);
    }

    public PK save(T entity) {
    	if(baseDao!=null){
    		 return baseDao.save(entity);
    	}else{
    		System.out.println("注入失败");
    		return null;
    	}
       
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

    public void delete(PK id) {
        baseDao.delete(id);
    }

    public void delete(PK[] ids) {
        baseDao.delete(ids);
    }

}
