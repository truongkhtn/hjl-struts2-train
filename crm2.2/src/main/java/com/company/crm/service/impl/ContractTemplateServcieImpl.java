package com.company.crm.service.impl;


import com.company.crm.dao.ContractTemplateDao;
import com.company.crm.entity.ContractTemplate;
import com.company.crm.service.ContractTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContractTemplateServcieImpl extends BaseServiceImpl<ContractTemplate, String> implements
        ContractTemplateService {

    @Resource
    public void setBaseDao(ContractTemplateDao contractTemplateDao) {
        super.setBaseDao(contractTemplateDao);
    }

}
