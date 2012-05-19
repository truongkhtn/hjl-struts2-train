package com.company.travel.service;

import com.company.travel.entity.Order;

/**
 * RouteService
 */
public interface OrderService extends BaseService<Order, String>{

    public void updateOrderStatus(String orderID, String status);

}
