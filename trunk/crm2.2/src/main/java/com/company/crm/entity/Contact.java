package com.company.crm.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * 联系人类
 */
@Entity
@Table(name="tbl_contact")
public class Contact extends BaseEntity{
	
	private static final long serialVersionUID = -3949633801748450797L;
	
	private String name; // 客户方的联系人
	private String gender; //性别
	private String title; //职称
	private String phone; //固定电话
	private String mobilePhone;//移动电话
	private String email;   //邮箱地址
	private Customer customer;//客户
	private boolean major;   //是否为主联系人

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ManyToOne
	@JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    public boolean isMajor() {
        return major;
    }
    public void setMajor(boolean major) {
        this.major = major;
    }
}
