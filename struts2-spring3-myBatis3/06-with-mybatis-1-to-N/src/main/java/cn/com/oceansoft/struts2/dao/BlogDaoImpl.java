package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Blog;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDaoImpl extends SqlSessionDaoSupport implements BlogDao {

    private static final String GET_BY_ID = "cn.com.oceansoft.struts2.dao.BlogDao.getById";
    private static final String DELETE_BY_ID = "cn.com.oceansoft.struts2.dao.BlogDao.deleteById";

    public void save(Blog blog) {
        this.getSqlSession().insert("saveBlog", blog);
    }

    public Blog getById(String id) {
        return (Blog) this.getSqlSession().selectOne(GET_BY_ID, id);
    }

    public void delete(String id) {
        this.getSqlSession().delete(DELETE_BY_ID, id);
    }
}
