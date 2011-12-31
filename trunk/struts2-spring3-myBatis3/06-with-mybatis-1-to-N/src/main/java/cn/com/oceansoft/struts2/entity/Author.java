package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;

/**
 * Author 实体类 , Author : Blog 是1对多
 *
 * @author 胡荆陵
 */
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    private String authorId; //作者主键
    private String authorName; //作者名称
    private String email; //邮箱

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
