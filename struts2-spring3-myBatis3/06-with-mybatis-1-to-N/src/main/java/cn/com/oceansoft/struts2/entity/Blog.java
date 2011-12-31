package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Blog 实体类 , Blog : Author 是多对1
 *
 * @author 胡荆陵
 */
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String blogId;// blog 主键
    private String blogName; //blog 主题
    private String content; //内容
    private Date createdDate; //创建日期
    private Date lastModifyDate; //最后修改日期

    private Author author; //外键 - 作者主键

    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId='" + blogId + '\'' +
                ", blogName='" + blogName + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifyDate=" + lastModifyDate +
                ", author=" + author +
                '}';
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
