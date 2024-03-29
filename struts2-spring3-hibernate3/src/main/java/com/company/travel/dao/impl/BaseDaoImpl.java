package com.company.travel.dao.impl;

import com.company.travel.controller.Pager;
import com.company.travel.controller.Pager.OrderType;
import com.company.travel.dao.BaseDao;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Dao实现类 - Dao实现类基类
 */

@SuppressWarnings({"JpaQlInspection"})
@Repository
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

    private Class<T> entityClass;
    protected SessionFactory sessionFactory;

    public BaseDaoImpl() {
        this.entityClass = null;
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T get(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().get(entityClass, id);
    }

    public T load(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().load(entityClass, id);
    }

    public List<T> get(PK[] ids) {
        Assert.notEmpty(ids, "ids must not be empty");
        String hql = "from " + entityClass.getName() + " as model where model.id in(:ids)";
        return getSession().createQuery(hql).setParameterList("ids", ids).list();
    }

    public T get(String propertyName, Object value) {
        Assert.hasText(propertyName, "propertyName must not be empty");
        Assert.notNull(value, "value is required");
        String hql = "from " + entityClass.getName() + " as model where model." + propertyName + " = ?";
        return (T) getSession().createQuery(hql).setParameter(0, value).uniqueResult();
    }

    public List<T> getList(String propertyName, Object value) {
        Assert.hasText(propertyName, "propertyName must not be empty");
        Assert.notNull(value, "value is required");
        String hql = "from " + entityClass.getName() + " as model where model." + propertyName + " = ?";
        return getSession().createQuery(hql).setParameter(0, value).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        String hql = "from " + entityClass.getName();
        return getSession().createQuery(hql).list();
    }

    public Long getTotalCount() {
        String hql = "select count(*) from " + entityClass.getName();
        return (Long) getSession().createQuery(hql).uniqueResult();
    }

    public boolean isUnique(String propertyName, Object oldValue, Object newValue) {
        Assert.hasText(propertyName, "propertyName must not be empty");
        Assert.notNull(newValue, "newValue is required");
        if (newValue == oldValue || newValue.equals(oldValue)) {
            return true;
        }
        if (newValue instanceof String) {
            if (oldValue != null && StringUtils.equalsIgnoreCase((String) oldValue, (String) newValue)) {
                return true;
            }
        }
        T object = get(propertyName, newValue);
        return (object == null);
    }

    public boolean isExist(String propertyName, Object value) {
        Assert.hasText(propertyName, "propertyName must not be empty");
        Assert.notNull(value, "value is required");
        T object = get(propertyName, value);
        return (object != null);
    }

    @SuppressWarnings("unchecked")
    public PK save(T entity) {
        Assert.notNull(entity, "entity is required");
        return (PK) getSession().save(entity);
    }

    @SuppressWarnings("unchecked")
    public void saveOrUpdate(T entity) {
        Assert.notNull(entity, "entity is required");
        getSession().saveOrUpdate(entity);
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

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    public void evict(Object object) {
        Assert.notNull(object, "object is required");
        getSession().evict(object);
    }

    public Pager findByPager(Pager pager) {
		if (pager == null) {
			pager = new Pager();
		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		return findByPager(pager, detachedCriteria);
	}

    public Pager findByPager(Pager pager, DetachedCriteria detachedCriteria) {
		if (pager == null) {
			pager = new Pager();
		}
		Integer pageNumber = pager.getPageNumber();
		Integer pageSize = pager.getPageSize();
		String property = pager.getProperty();
		String keyword = pager.getKeyword();
		String[] orderBys = pager.getOrderBys();
		OrderType[] orderTypes = pager.getOrderTypes();

		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
		if (StringUtils.isNotEmpty(property) && StringUtils.isNotEmpty(keyword)) {
			String propertyString = "";
			if (property.contains(".")) {
				String propertyPrefix = StringUtils.substringBefore(property, ".");
				String propertySuffix = StringUtils.substringAfter(property, ".");
				criteria.createAlias(propertyPrefix, "model");
				propertyString = "model." + propertySuffix;
			} else {
				propertyString = property;
			}
			criteria.add(Restrictions.like(propertyString, "%" + keyword + "%"));
		}

		Long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        Integer intTotalCount = Integer.parseInt(String.valueOf(totalCount));

		criteria.setProjection(null);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		criteria.setFirstResult((pageNumber - 1) * pageSize);
		criteria.setMaxResults(pageSize);
        if (orderBys != null) {
            for (int i = 0; i < orderBys.length; i++) {
                String orderBy = orderBys[i];
                if (StringUtils.isEmpty(orderBy) && orderTypes == null)
                    continue;
                if (orderTypes[i] == OrderType.asc) {
                    criteria.addOrder(Order.asc(orderBy));
                } else {
                    criteria.addOrder(Order.desc(orderBy));
                }
            }
        }
		pager.setTotalCount(intTotalCount);
		pager.setList(criteria.list());
		return pager;
	}

}