package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;

/*
* Author: Hu jingling
* Description: User Entity
*/
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

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

    public String toString() {
        StringBuilder buf = new StringBuilder(30);
        buf.append("{");
        buf.append(id);
        buf.append(", ");
        buf.append(name);
        buf.append("}");
        return buf.toString();
    }


}
