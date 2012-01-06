package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;
import java.util.List;

/**
 * User 实体类
 *
 * @author 胡荆陵
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId; //主键
    private String name; //姓名
    private String gender; //性别
    private String state; //状态
    private String email; //邮箱

    //空构造
    public User() {
    }

    //全构造
    public User(String userId, String name, String gender, String state, String email) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.state = state;
        this.email = email;
    }

    //getter & setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
