package cn.com.oceansoft.struts2.entity;

import java.io.Serializable;
import java.util.List;

public class AuthorBlogLinked implements Serializable {

    private static final long serialVersionUID = 1L;

    private Author author;
    private List<Blog> blogList;

    public AuthorBlogLinked() {
    }

    @Override
    public String toString() {
        return "AuthorBlogLinked{" + "author=" + author + ", blogList=" + blogList.size() +'}';
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
