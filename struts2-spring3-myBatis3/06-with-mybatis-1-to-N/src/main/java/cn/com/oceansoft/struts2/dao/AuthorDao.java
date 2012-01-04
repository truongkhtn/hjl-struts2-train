package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Author;
import java.util.List;

public interface AuthorDao {

    Author getById(String id);

    List getAll();

}
