package com.company.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_visit_type")
public class VisitType extends BaseEntity{

	private static final long serialVersionUID = -7175971357033853874L;
    private String value;  //键
	private String name; //值
    private boolean valid;//是否有效
    private int req;  //排序需要
    private String remark; //备注

    @Column(unique = true, nullable = false)
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    public int getReq() {
		return req;
	}
	public void setReq(int req) {
		this.req = req;
	}
	
}
