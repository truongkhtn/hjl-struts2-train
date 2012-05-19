package com.company.travel.service.impl;

import com.company.travel.dao.OrderDao;
import com.company.travel.entity.Order;
import com.company.travel.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * RouteServiceImpl
 */
@Service
@Transactional
public class OrderServiceImpl extends BaseServiceImpl<Order, String> implements OrderService {

    @Resource
    OrderDao orderDao;

    @Resource
    public void setBaseDao(OrderDao orderDao) {
        super.setBaseDao(orderDao);
    }

    public void updateOrderStatus(String orderID, String status) {
        orderDao.updateOrderStatus(orderID, status);
    }
}
