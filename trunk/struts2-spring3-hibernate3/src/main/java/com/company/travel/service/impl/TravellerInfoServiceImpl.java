package com.company.travel.service.impl;

import com.company.travel.dao.TravellerInfoDao;
import com.company.travel.entity.TravellerInfo;
import com.company.travel.service.TravellerInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * TravellerInfoServiceImpl
 */
@Service
@Transactional
public class TravellerInfoServiceImpl extends BaseServiceImpl<TravellerInfo, String> implements TravellerInfoService{

    @Resource
    public void setBaseDao(TravellerInfoDao travellerInfoDao) {
        super.setBaseDao(travellerInfoDao);
    }
}
