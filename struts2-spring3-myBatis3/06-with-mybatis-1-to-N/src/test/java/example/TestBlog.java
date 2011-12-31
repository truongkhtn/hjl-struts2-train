package example;

import cn.com.oceansoft.struts2.dao.BlogDao;
import cn.com.oceansoft.struts2.entity.Author;
import cn.com.oceansoft.struts2.entity.Blog;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.Date;

@ContextConfiguration({"classpath:application-config.xml"})
public class TestBlog extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private BlogDao blogDao;

    @Test
    public void simple(){
    }

    @Test
    @Rollback(value = false)
    public void save(){
        Blog blog = new Blog();
        blog.setBlogId("test1");
        blog.setBlogName("Test111");
        blog.setContent("content111");
        blog.setCreatedDate(new Date());
        Author author = new Author();
        author.setAuthorId("author1");
        blog.setAuthor(author);
        blogDao.save(blog);
    }

    @Test
    @Rollback(value = false)
    public void delete(){
        blogDao.delete("test1");
    }

    @Test
    public void getById(){
        Blog blog = blogDao.getById("test1");
        System.out.println(blog.toString());
    }

}
