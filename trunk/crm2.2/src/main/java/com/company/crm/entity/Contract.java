package com.company.crm.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*
 * 合同实体类
 */
@Entity
@Table(name="tbl_contract")
public class Contract extends BaseEntity{

	private static final long serialVersionUID = 381397960152691566L;
	
	private ContractTemplate  contractTemplate ;//模板
	private Set<Property> propertySet;//合同属性
	private String cNumber;//公司合同号
	private String cNo;//客户定单号
	private String cName;//公司名称
	private Date signDate;//签约日期
	private double amount;//金额
	private User signUser;//合约签署人
	private Date startDate;//合同起始日
	private Date endDate;//合同结束日
	private String remark;//备注
	private Set<Payment> payPlan;//付款计划	
	private boolean isdistroy;//合同是否销毁
	
	@ManyToOne
	@JoinColumn(name="contract_template_id")
	public ContractTemplate getContractTemplate() {
		return contractTemplate;
	}
	public void setContractTemplate(ContractTemplate contractTemplate) {
		this.contractTemplate = contractTemplate;
	}
	public String getcNumber() {
		return cNumber;
	}
	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}	
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getSignUser() {
		return signUser;
	}
	public void setSignUser(User signUser) {
		this.signUser = signUser;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@OneToMany(mappedBy="contract",cascade={CascadeType.ALL})
	public Set<Payment> getPayPlan() {
		return payPlan;
	}
	public void setPayPlan(Set<Payment> payPlan) {
		this.payPlan = payPlan;
	}
	public boolean isIsdistroy() {
		return isdistroy;
	}
	public void setIsdistroy(boolean isdistroy) {
		this.isdistroy = isdistroy;
	}
	@OneToMany(mappedBy="contract",cascade={CascadeType.ALL})
	public Set<Property> getPropertySet() {
		return propertySet;
	}
	public void setPropertySet(Set<Property> propertySet) {
		this.propertySet = propertySet;
	}	
}
