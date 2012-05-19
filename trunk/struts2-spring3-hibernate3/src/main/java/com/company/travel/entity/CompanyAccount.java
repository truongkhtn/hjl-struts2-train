package com.company.travel.entity;

import javax.persistence.*;

/**
 * 实体类 - 旅游线路,如：黄山2日游,黄山3日游
 * 一个 Route 包含多个 Journey
 */
@Entity
@Table(name="tbl_companyAccount")
public class CompanyAccount extends BaseEntity{

    // 公司ID
    private String companyID;
	// 序号
	private String seq;
	// 银行名称
	private String blankName;
	// 户名
	private String userName;
	// 账号
	private String account;
	// 开户行
	private String openAccountName;

    //constructors
    public CompanyAccount() {
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBlankName() {
        return blankName;
    }

    public void setBlankName(String blankName) {
        this.blankName = blankName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenAccountName() {
        return openAccountName;
    }

    public void setOpenAccountName(String openAccountName) {
        this.openAccountName = openAccountName;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
