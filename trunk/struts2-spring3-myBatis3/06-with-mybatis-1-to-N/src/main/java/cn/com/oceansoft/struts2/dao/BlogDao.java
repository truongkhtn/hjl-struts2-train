package cn.com.oceansoft.struts2.dao;


import cn.com.oceansoft.struts2.entity.Blog;

public interface BlogDao {

    void save(Blog blog);

    Blog getById(String id);

    void delete(String id);

}
