package com.company.crm.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role extends BaseEntity{

	private static final long serialVersionUID = 7690574995629823045L;
	
	private String roleKey;//角色的键
	private String roleValue;//角色的值
	private String remark; //角色的描述
    private int seq; //排序
	private Set<User> userSet;//一个角色包涵多个用户

    @Column(unique = true)
    public String getRoleKey() {
        return roleKey;
    }
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    @Column(unique = true)
    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    @ManyToMany(mappedBy="roleSet")
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
}
