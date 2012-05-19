package com.company.travel.service.impl;

import com.company.travel.dao.RoutePriceDao;
import com.company.travel.entity.RoutePrice;
import com.company.travel.service.RoutePriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * RoutePriceServiceImpl
 */
@Service
@Transactional
public class RoutePriceServiceImpl extends BaseServiceImpl<RoutePrice, String> implements RoutePriceService {

    @Resource
    public void setBaseDao(RoutePriceDao routePriceDao) {
        super.setBaseDao(routePriceDao);
    }
}
