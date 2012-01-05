package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Group 实体类
 *
 * @author 胡荆陵
 */
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    private String groupId; //主键
    private String name; //名称
    private String remark; //备注

    private List<User> userList; // 用户列表

    //空构造
    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", userList=" + userList.size() +
                '}';
    }

    //getter & setter
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}


