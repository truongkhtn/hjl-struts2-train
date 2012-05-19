package com.company.travel.dao.impl;

import com.company.travel.dao.RoutePriceDao;
import com.company.travel.entity.RoutePrice;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * RouteDaoImpl
 */
@Repository
public class RoutePriceDaoImpl extends BaseDaoImpl<RoutePrice, String> implements RoutePriceDao {

    @Override
    public List<RoutePrice> getAll() {
        String hql = "from RoutePrice order by publishDate, routeID ";
        return getSession().createQuery(hql).list();
    }

    @Override
    public String save(RoutePrice routePrice) {
        String hql = "";
        List<RoutePrice> routePriceList = null;
        if (routePrice.getId() != null && !routePrice.getId().equals("")) {
            hql = "from RoutePrice where id = :routePriceID ";
            routePriceList = getSession().createQuery(hql)
                    .setParameter("routePriceID", routePrice.getId()).list();
        } else {
            hql = "from RoutePrice where routeID = :routeID and publishDate = :publishDate ";
            routePriceList = getSession().createQuery(hql)
                    .setParameter("routeID", routePrice.getRouteID())
                    .setParameter("publishDate", routePrice.getPublishDate()).list();
        }
        if (routePriceList != null && routePriceList.size() > 0) {
            // 更新处理
            RoutePrice dbRoutePrice = routePriceList.get(0);
            // 儿童价格         ;
            dbRoutePrice.setChildenPrice(routePrice.getChildenPrice());
            // 成人价格
            dbRoutePrice.setAdultPrice(routePrice.getAdultPrice());
            // 去程航班信息
            dbRoutePrice.setStartFlightInfo(routePrice.getStartFlightInfo());
            // 返程航班信息
            dbRoutePrice.setEndFlightInfo(routePrice.getEndFlightInfo());
            // 人数
            dbRoutePrice.setTotalPeople(routePrice.getTotalPeople());
            getSession().update(dbRoutePrice);
        } else {
            // 追加处理
            getSession().save(routePrice);
        }
        return "";
    }

}
