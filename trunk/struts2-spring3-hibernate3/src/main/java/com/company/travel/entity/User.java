package com.company.travel.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 实体类 - 用户
 */
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String username;// 用户名
    private String password;// 密码
    private String realName;// 真实姓名

    //对象间关系
    private Set<Group> groupSet;//

    private Set<MessageLog> messageLogs;

    // Constructors
    public User() {
    }

    @Column(updatable = false, nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("name asc")
    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "user")
    @OrderBy("seq asc")
    public Set<MessageLog> getMessageLogs() {
        return messageLogs;
    }

    public void setMessageLogs(Set<MessageLog> messageLogs) {
        this.messageLogs = messageLogs;
    }
}