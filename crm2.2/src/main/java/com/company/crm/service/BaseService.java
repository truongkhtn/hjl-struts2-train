package com.company.crm.service;
import java.io.Serializable;
import java.util.List;

/**
 * Service接口 - Service接口基类
 */

public interface BaseService<T, PK extends Serializable> {

	/**
     * 根据ID获取实体对象.
     *
     * @param id 记录ID
     * @return 实体对象
     */
    public T get(PK id);

    /**
     * 根据ID数组获取实体对象集合.
     *
     * @param ids ID对象数组
     * @return 实体对象集合
     */
    public List<T> get(PK[] ids);

    /**
     * 根据属性名和属性值获取实体对象.
     *
     * @param propertyName 属性名称
     * @param value        属性值
     * @return 实体对象
     */
    public T get(String propertyName, Object value);

    /**
     * 根据属性名和属性值获取实体对象集合.
     *
     * @param propertyName 属性名称
     * @param value        属性值
     * @return 实体对象集合
     */
    public List<T> getList(String propertyName, Object value);

    /**
     * 获取所有实体对象集合.
     *
     * @return 实体对象集合
     */
    public List<T> getAll();

    /**
     * 获取所有实体对象总数.
     *
     * @return 实体对象总数
     */
    public Long getTotalCount();

    /**
     * 根据属性名判断数据是否已存在.
     *
     * @param propertyName 属性名称
     * @param value        值
     * @return boolean
     */
    public boolean isExist(String propertyName, Object value);

    /**
     * 保存实体对象.
     *
     * @param entity 对象
     * @return ID
     */
    public PK save(T entity);

    /**
     * 更新实体对象.
     *
     * @param entity 对象
     */
    public void update(T entity);

    /**
     * 删除实体对象.
     *
     * @param entity 对象
     * @return
     */
    public void delete(T entity);

    /**
     * 根据ID删除实体对象.
     *
     * @param id 记录ID
     */
    public void delete(PK id);

    /**
     * 根据ID数组删除实体对象.
     *
     * @param ids ID数组
     */
    public void delete(PK[] ids);

}
