package com.company.travel.dao.impl;

import com.company.travel.dao.TravellerInfoDao;
import com.company.travel.entity.TravellerInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RouteDaoImpl
 */
@Repository
public class TravellerInfoDaoImpl extends BaseDaoImpl<TravellerInfo, String> implements TravellerInfoDao {

    @Override
    public List<TravellerInfo> getList(String propertyName, Object value) {
        String hql = "from TravellerInfo where " + propertyName + " = ? order by seq asc ";
        return getSession().createQuery(hql).setParameter(0, value).list();
    }

}
