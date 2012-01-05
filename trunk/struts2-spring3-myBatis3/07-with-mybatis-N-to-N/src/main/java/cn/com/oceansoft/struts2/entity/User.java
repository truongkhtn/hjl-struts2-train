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

    private List<Group> groupList;// 分组列表

    //空构造
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", groupList=" + groupList.size() +
                '}';
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

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
}
