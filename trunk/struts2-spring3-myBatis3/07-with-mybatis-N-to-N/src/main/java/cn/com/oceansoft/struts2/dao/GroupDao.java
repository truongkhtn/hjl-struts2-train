package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Group;

import java.util.List;

public interface GroupDao {

    Group getById(String id);

    List getAll();

}
