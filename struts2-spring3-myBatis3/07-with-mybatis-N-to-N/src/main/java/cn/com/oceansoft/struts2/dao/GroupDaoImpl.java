package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Group;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class GroupDaoImpl extends SqlSessionDaoSupport implements GroupDao{

    public Group getById(String id) {
        return (Group) this.getSqlSession().selectOne("cn.com.oceansoft.struts2.dao.Group.getById" , id);
    }

    public List getAll() {
        return this.getSqlSession().selectList("cn.com.oceansoft.struts2.dao.Group.getAll");
    }
}
