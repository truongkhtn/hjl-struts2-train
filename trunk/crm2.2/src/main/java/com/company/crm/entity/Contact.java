package com.company.crm.entity;

import com.company.crm.utils.Gender;

import javax.persistence.*;

/*
 * 联系人类
 */
@Entity
@Table(name="tbl_contact")
public class Contact extends BaseEntity{
	private static final long serialVersionUID = -3949633801748450797L;

    public enum Title{
        GENERAL, //总经理
        MANAGER, //经理
        ACCOUNT, //财务
        ADMIN, //行政
        SALESMAN, //销售
        ASSISTANT //助理
    }

	private String name; // 联系人姓名
	private Gender gender; //性别
	private Title title; //职称
	private String phone; //固定电话
	private String mobilePhone;//移动电话
	private String email;   //邮箱地址
	private Customer customer;//客户
    private String qq;//QQ号
    private String remark;//备注
	private boolean major;   //是否为主联系人

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Enumerated(EnumType.STRING)
    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
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
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
