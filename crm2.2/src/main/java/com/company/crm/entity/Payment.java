package com.company.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
 * 付款计划
 */
@Entity
@Table(name="tbl_payment")
public class Payment extends BaseEntity{

	private static final long serialVersionUID = 4070590554145379906L;

	public enum PayName{
		firstPay,
		leftPay,
		lastPay
	}
	
	private PayName payName;//付款方式
	private double amount;//金额
	private String remark;//备注
	private Date PayOffDate;//到款日期
	private User signUser;//签约确认人
	private Contract contract; //属于哪个合同
	@Enumerated(EnumType.STRING)
	public PayName getPayName() {
		return payName;
	}
	public void setPayName(PayName payName) {
		this.payName = payName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getPayOffDate() {
		return PayOffDate;
	}
	public void setPayOffDate(Date payOffDate) {
		PayOffDate = payOffDate;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getSignUser() {
		return signUser;
	}
	public void setSignUser(User signUser) {
		this.signUser = signUser;
	}
	@ManyToOne
	@JoinColumn(name="contract_id")
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
}
