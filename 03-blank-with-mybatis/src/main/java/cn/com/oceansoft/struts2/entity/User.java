package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;
import java.util.Date;

/*
* Author: Hu jingling
* Description: User Entity
*/
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Date birthday;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
