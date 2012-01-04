package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Author;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AuthorDaoImpl extends SqlSessionDaoSupport implements AuthorDao{

    private static final String GET_BY_ID = "cn.com.oceansoft.struts2.dao.Author.getById";

    public Author getById(String id) {
        return (Author) this.getSqlSession().selectOne(GET_BY_ID , id);
    }

    public List getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
