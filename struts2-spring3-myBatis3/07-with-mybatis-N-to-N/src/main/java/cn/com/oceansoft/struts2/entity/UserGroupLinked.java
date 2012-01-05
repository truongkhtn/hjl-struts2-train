package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;

/**
 * @author 胡荆陵
 * @describe: 描述 User 和 Group 之间的映射关系
 */

public class UserGroupLinked implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user; //用户
    private Group group; //分组

    //空构造
    public UserGroupLinked() {
    }

    //getter & setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
