package com.company.crm.dao;

import java.util.List;

import com.company.crm.action.Pager;
import com.company.crm.entity.Contract;

public interface ContractDao extends BaseDao<Contract, String>{
	
	/**
	 * 根据用户选择查询合同
	 * @param contract
	 * @return
	 */
	List<Contract> get(Contract contract, Pager pager);
	
	/**
	 * 根据合同编号查找合同
	 * @param contractNum
	 * @return
	 */
	Contract getByNum(String contractNum);
	
	/**
	 * 根据用户选择查询合同数量
	 * @param contract
	 * @return
	 */	
	int getCount(Contract contract);
	
}
