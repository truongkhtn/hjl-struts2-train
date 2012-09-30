package com.company.crm.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * 套餐属性 
 */
@Entity
@Table(name="tbl_property")
public class Property extends BaseEntity{
	
	private static final long serialVersionUID = 2506418151081484694L;

	public enum TypeIn{
		pickFromList,
		writeByHand,
		checkBoxList
	}

	
	private String name;//名
	private TypeIn typeIn;//录入方式
	private String list;//列表选择
	private Contract contract;//
	private ContractTemplate contractTemplate;//属于那个模版
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Enumerated(EnumType.STRING)
	public TypeIn getTypeIn() {
		return typeIn;
	}
	public void setTypeIn(TypeIn typeIn) {
		this.typeIn = typeIn;
	}
	
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	@ManyToOne
	@JoinColumn(name="contract_id")
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	@ManyToOne
	@JoinColumn(name="contract_template_id")
	public ContractTemplate getContractTemplate() {
		return contractTemplate;
	}
	public void setContractTemplate(ContractTemplate contractTemplate) {
		this.contractTemplate = contractTemplate;
	}
	
}
