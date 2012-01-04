package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Author;
import cn.com.oceansoft.struts2.entity.AuthorBlogLinked;

import java.util.List;

public interface AuthorDao {

    Author getById(String id);

    AuthorBlogLinked getAuthorBlogLinkedById(String id);

    List getAll();

}
