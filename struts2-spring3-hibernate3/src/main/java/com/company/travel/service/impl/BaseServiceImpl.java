package com.company.travel.service.impl;

import com.company.travel.controller.Pager;
import com.company.travel.dao.BaseDao;
import com.company.travel.service.BaseService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Service实现类 - Service实现类基类
 */

@Transactional
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

    public T load(PK id) {
        return baseDao.load(id);
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

    public boolean isUnique(String propertyName, Object oldValue, Object newValue) {
        return baseDao.isUnique(propertyName, oldValue, newValue);
    }

    public boolean isExist(String propertyName, Object value) {
        return baseDao.isExist(propertyName, value);
    }

    public PK save(T entity) {
        return baseDao.save(entity);
    }

    public void saveOrUpdate(T entity) {
        baseDao.saveOrUpdate(entity);
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

    public void flush() {
        baseDao.flush();
    }

    public void clear() {
        baseDao.clear();
    }

    public void evict(Object object) {
        baseDao.evict(object);
    }

    public Pager findByPager(Pager pager) {
        return baseDao.findByPager(pager);
    }

    public Pager findByPager(Pager pager, DetachedCriteria detachedCriteria) {
		return baseDao.findByPager(pager, detachedCriteria);
	}

}
