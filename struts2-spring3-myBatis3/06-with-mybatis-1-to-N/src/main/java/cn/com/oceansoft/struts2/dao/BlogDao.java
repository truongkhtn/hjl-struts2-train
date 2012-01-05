package cn.com.oceansoft.struts2.dao;


import cn.com.oceansoft.struts2.entity.Blog;

import java.util.List;

public interface BlogDao {

    void save(Blog blog);

    Blog getById(String id);

    List getAll();

    void delete(String id);

    Blog getByIdLazy(String id);

}
