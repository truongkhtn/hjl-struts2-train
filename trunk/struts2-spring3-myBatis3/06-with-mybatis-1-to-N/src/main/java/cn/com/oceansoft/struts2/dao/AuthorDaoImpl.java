package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.Author;
import cn.com.oceansoft.struts2.entity.AuthorBlogLinked;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AuthorDaoImpl extends SqlSessionDaoSupport implements AuthorDao{

    private static final String GET_BY_ID = "cn.com.oceansoft.struts2.dao.Author.getById";
    private static final String GET_AUTHOR_BLOG_LINKED_BY_ID = "cn.com.oceansoft.struts2.dao.Author.getAuthorBlogLinkedById";
    private static final String GET_ALL_AUTHOR_BLOG_LINKED = "cn.com.oceansoft.struts2.dao.Author.getAllAuthorBlogLinked";

    public Author getById(String id) {
        return (Author) this.getSqlSession().selectOne(GET_BY_ID , id);
    }

    public AuthorBlogLinked getAuthorBlogLinkedById(String id) {
        return (AuthorBlogLinked) this.getSqlSession().selectOne(GET_AUTHOR_BLOG_LINKED_BY_ID , id);
    }

    public List getAll() {
        return this.getSqlSession().selectList(GET_ALL_AUTHOR_BLOG_LINKED);
    }
}
