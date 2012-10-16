package com.company.crm.dao.impl;

import com.company.crm.action.Pager;
import com.company.crm.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;



/**
 * Dao实现类 - Dao实现类基类
 */
@Repository
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

    private Class<T> entityClass;
    protected SessionFactory sessionFactory;
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
        this.entityClass = null;
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T get(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().get(entityClass, id);
    }

    public List<T> get(PK[] ids) {
        Assert.notEmpty(ids, "ids must not be empty");
        String hql = "from " + entityClass.getName() + " as model where model.id in(:ids)";
        return getSession().createQuery(hql).setParameterList("ids", ids).list();
    }

    public T get(String propertyName, Object value) {
        Assert.hasText(propertyName, "propertyName must not be empty");
        Assert.notNull(value, "value is required");
        String hql = "from " + entityClass.getName() + " as model where model." + propertyName + " = :propertyValue";
        return (T) getSession().createQuery(hql).setParameter("propertyValue", value).uniqueResult();
    }

    public List<T> getList(String propertyName, Object value) {
        Assert.hasText(propertyName, "propertyName must not be empty");
        Assert.notNull(value, "value is required");
        String hql = "from " + entityClass.getName() + " as model where model." + propertyName + " = :propertyValue";
        return getSession().createQuery(hql).setParameter("propertyValue", value).list();
    }

    public List<T> getAll() {
        String hql = "from " + entityClass.getName();
        return getSession().createQuery(hql).list();
    }

    public Long getTotalCount() {
        String hql = "select count(*) from " + entityClass.getName();
        return (Long) getSession().createQuery(hql).uniqueResult();
    }

    public boolean isExist(String propertyName, Object value) {
        Assert.hasText(propertyName, "propertyName must not be empty");
        Assert.notNull(value, "value is required");
        T object = get(propertyName, value);
        return (object != null);
    }

    public PK save(T entity) {
        Assert.notNull(entity, "entity is required");
        return (PK) getSession().save(entity);
    }

    public void update(T entity) {
        Assert.notNull(entity, "entity is required");
        getSession().update(entity);
    }

    public void delete(T entity) {
        Assert.notNull(entity, "entity is required");
        getSession().delete(entity);
    }

    public void delete(PK id) {
        Assert.notNull(id, "id is required");
        T entity = load(id);
        getSession().delete(entity);
    }

    public void delete(PK[] ids) {
        Assert.notEmpty(ids, "ids must not be empty");
        for (PK id : ids) {
            T entity = load(id);
            getSession().delete(entity);
        }
    }

    @SuppressWarnings("unchecked")
	public T load(PK id) {
		Assert.notNull(id, "id is required");
		return (T) getSession().load(entityClass, id);
	}

    public Pager findByPager(Pager pager, DetachedCriteria detachedCriteria) {
        if(pager == null){
            pager = new Pager();
        }
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
         //total
        criteria.setProjection(Projections.rowCount());
        long lTotal = (Long)criteria.uniqueResult();
        pager.setTotalCount(Integer.valueOf(String.valueOf(lTotal)));
        //pager
        criteria.setProjection(null);
        criteria.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
		criteria.setMaxResults(pager.getPageSize());
        pager.setList(criteria.list());
        return pager;
    }

}