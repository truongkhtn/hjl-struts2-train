package com.company.travel.dao;

import com.company.travel.entity.Order;

/**
 * RouteDao
 */
public interface OrderDao extends BaseDao<Order, String>{

    public void updateOrderStatus(String orderID, String status);

}
