package example;

import cn.com.oceansoft.struts2.dao.AuthorDao;
import cn.com.oceansoft.struts2.entity.Author;
import cn.com.oceansoft.struts2.entity.AuthorBlogLinked;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration({"classpath:application-config.xml"})
public class TestAuthor extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private AuthorDao authorDao;

    @Test
    public void simple() {
    }

    //只读取 Author 信息
    @Test
    public void testGetById(){
        Author author = authorDao.getById("author1");
        System.out.println(author.toString());
    }

    //1对多，取一条记录
    @Test
    public void testAuthorBlogLinkedById() {
        AuthorBlogLinked authorBlogLinked = authorDao.getAuthorBlogLinkedById("author1");
        System.out.println(authorBlogLinked.toString());
    }

    //1对多，取多条记录
    @Test
    public void getAll(){
        List list = authorDao.getAll();
        System.out.println(list.size());
    }


}
