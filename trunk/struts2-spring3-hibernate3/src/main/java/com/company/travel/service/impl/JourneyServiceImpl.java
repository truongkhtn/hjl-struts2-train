package com.company.travel.service.impl;

import com.company.travel.dao.JourneyDao;
import com.company.travel.entity.Journey;
import com.company.travel.service.JourneyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * JourneyServiceImpl
 */
@Service
@Transactional
public class JourneyServiceImpl extends BaseServiceImpl<Journey , String> implements JourneyService {

    @Resource
    public void setBaseDao(JourneyDao journeyDao) {
        super.setBaseDao(journeyDao);
    }
}
