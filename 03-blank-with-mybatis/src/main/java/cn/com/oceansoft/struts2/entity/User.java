package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * User 实体类
 *
 * @author 胡荆陵
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id; //主键
    private String name; //姓名
    private Date birthday; //生日

    //构造方法
    public User() {
    }

    //全构造
    public User(String id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    //getter & setter
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
