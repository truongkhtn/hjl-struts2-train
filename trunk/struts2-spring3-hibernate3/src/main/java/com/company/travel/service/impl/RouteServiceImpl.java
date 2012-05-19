package com.company.travel.service.impl;

import com.company.travel.dao.BaseDao;
import com.company.travel.dao.RouteDao;
import com.company.travel.entity.Route;
import com.company.travel.service.RouteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * RouteServiceImpl
 */
@Service
@Transactional
public class RouteServiceImpl extends BaseServiceImpl<Route , String> implements RouteService{

    @Resource
    public void setBaseDao(RouteDao routeDao) {
        super.setBaseDao(routeDao);
    }
}
