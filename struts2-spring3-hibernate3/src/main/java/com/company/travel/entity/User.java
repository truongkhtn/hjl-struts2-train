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
    private String realname;// 真实姓名
    private boolean isAdmin; //是否管理员

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
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @ManyToMany(fetch = FetchType.EAGER)
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    @Transient
    public String getDisplayGroups() {
        String result = "";
        Set<Group> set = this.getGroupSet();
        for(Group g : set){
            result += g.getName() + ",";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
