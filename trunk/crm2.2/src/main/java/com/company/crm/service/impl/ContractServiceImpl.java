package com.company.crm.service.impl;

import com.company.crm.action.Pager;
import com.company.crm.dao.ContractDao;
import com.company.crm.entity.Contract;
import com.company.crm.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract, String>
		implements ContractService {
	@Resource
	private ContractDao contractDao;
	
	@Resource
	public void setBaseDao(ContractDao contractDao) {
		super.setBaseDao(contractDao);
	}
	
	
	public List<Contract> get(Contract contract, Pager pager) {
		return contractDao.get(contract, pager);
	}

	public Contract getByNum(String contractNum) {
		return contractDao.getByNum(contractNum);
	}


	public int getCount(Contract contract) {
		return contractDao.getCount(contract);
	}


}
