package com.company.travel.dao.impl;

import com.company.travel.dao.OrderDao;
import com.company.travel.entity.Order;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;



/**
 * RouteDaoImpl
 */
@Repository
public class OrderDaoImpl extends BaseDaoImpl<Order, String> implements OrderDao {

    public void updateOrderStatus(String orderID, String status) {
        String hql = "update Order set status = :status where id = :orderID";
		Query query = getSession().createQuery(hql);
		query.setString("orderID", orderID);
		query.setString("status", status);
		query.executeUpdate();
    }

}
