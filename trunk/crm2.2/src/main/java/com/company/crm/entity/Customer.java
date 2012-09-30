package com.company.crm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *   客户 实体类
 */
@Entity
@Table(name="tbl_customer")
public class Customer extends BaseEntity{
	
	private static final long serialVersionUID = -1634517509763085662L;
	public enum Status{
		SIGHED,
		UNSIGHED,
	}
	
	public enum Source{
		VISIT,
		WEB,
		YELLOW_PAGES,
		DROP_IN,
		MEDIUM
	}

	private String name;//客户名
	private String address; //地址
	private String address2; //其他地址
	private String level;//信用等级
	private Source source;//客户来源
	private String fax;//传真号
	private String webSite;//网站
	private String business;//客户行业
	private String remark;//客户描述
	private Status status;//签约与否
	private Set<Contact> contractorsSet;//联系人集合
	private Set<VisitRecord> visitRecodeSet;//拜访记录
	private Contact contact; //主联系人
	private User user;//客户所属用户
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL})
	public Set<Contact> getContractorsSet() {
		return contractorsSet;
	}
	public void setContractorsSet(Set<Contact> contractorsSet) {
		this.contractorsSet = contractorsSet;
	}
	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL})
	public Set<VisitRecord> getVisitRecodeSet() {
		return visitRecodeSet;
	}
	public void setVisitRecodeSet(Set<VisitRecord> visitRecodeSet) {
		this.visitRecodeSet = visitRecodeSet;
	}
	@OneToOne
	@JoinColumn(name="contract_id")
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
