package com.company.crm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * 模板模式类
 */
@Entity
@Table(name="tbl_contract_template")
public class ContractTemplate extends BaseEntity{

	private static final long serialVersionUID = -7722391501257641822L;
	
	private boolean status;//状态 是否启用
	private String remark;//备注信息
	private String name;//合同模版名
	private Set<Contract> contractSet;
	private Set<Property> propertySet;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="contractTemplate",cascade={CascadeType.ALL})
	public Set<Contract> getContractSet() {
		return contractSet;
	}
	public void setContractSet(Set<Contract> contractSet) {
		this.contractSet = contractSet;
	}
	@OneToMany(mappedBy="contractTemplate",cascade={CascadeType.ALL})
	public Set<Property> getPropertySet() {
		return propertySet;
	}
	public void setPropertySet(Set<Property> propertySet) {
		this.propertySet = propertySet;
	}	
	
}
