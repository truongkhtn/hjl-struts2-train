package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Blog;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDaoImpl extends SqlSessionDaoSupport implements BlogDao {

    private static final String GET_BY_ID = "cn.com.oceansoft.struts2.dao.BlogDao.getById";
    private static final String DELETE_BY_ID = "cn.com.oceansoft.struts2.dao.BlogDao.deleteById";
    private static final String GET_ALL = "cn.com.oceansoft.struts2.dao.BlogDao.getAll";

    public void save(Blog blog) {
        this.getSqlSession().insert("saveBlog", blog);
    }

    public Blog getById(String id) {
        return (Blog) this.getSqlSession().selectOne(GET_BY_ID, id);
    }

    public List getAll() {
        return this.getSqlSession().selectList(GET_ALL);
    }

    public void delete(String id) {
        this.getSqlSession().delete(DELETE_BY_ID, id);
    }

    public Blog getByIdLazy(String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
