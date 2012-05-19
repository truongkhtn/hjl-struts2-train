package com.company.travel.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 实体类 - 资源
 * 用法：根据项目实际需要，进行灵活设置
 * 例子1: {name:/test; value:ROLE_ADMIN; description: 要访问/test 路径，需要有 ROLE_ADMIN 角色}
 * 例子2: {name:KEY_PARAM; value:30; description: 一个 KEY_PARAM 资源，并且取值为 30}
 */

@Entity
@Table(name = "tbl_comm_res")
public class Resource extends BaseEntity {

    private static final long serialVersionUID = 8231644891304446093L;

    public static final String SEPARATOR = ",";

    private String name;// 资源名称
    private String value;// 资源标识
    private Boolean isSystem;// 是否为系统内置资源
    private String description;// 描述
    private Integer seq;// 排序

    //对象间关系
    private Set<Role> roleSet;// 权限

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(nullable = false, updatable = false, columnDefinition = "BOOLEAN")
    public Boolean getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Boolean isSystem) {
        this.isSystem = isSystem;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //    @Column(nullable = false, unique = true)
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @ManyToMany(mappedBy = "resourceSet", fetch = FetchType.LAZY)
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    // 获取权限字符串（以分隔符间隔）
    @Transient
    public String getRoleSetString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.roleSet == null || this.roleSet.size() == 0) {
            return "";
        }
        for (Role role : this.roleSet) {
            stringBuffer.append(SEPARATOR + role.getValue());
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(0);
        }
        return stringBuffer.toString();
    }

}