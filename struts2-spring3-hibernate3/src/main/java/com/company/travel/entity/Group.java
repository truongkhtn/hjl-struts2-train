package com.company.travel.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 实体类 - 用户分组
 */
@Entity
@Table(name = "tbl_group")
public class Group extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;  //名称
    private String description;// 描述
    private Set<User> userSet;// 用户
    private int seq; //排序
    private boolean selected;//默认选中

    public Group() {
    }

    public Group(String name , int seq) {
        this.name = name;
        this.seq = seq;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groupSet")
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

