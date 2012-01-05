package example;


import cn.com.oceansoft.struts2.dao.UserDao;
import cn.com.oceansoft.struts2.entity.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@ContextConfiguration({"classpath:application-config.xml"})
public class TestUser extends AbstractTransactionalJUnit4SpringContextTests{

    @Resource
    private UserDao userDao;

    @Test
    @Ignore
    public void simple(){
    }

    @Test
    public void getById(){
        User user = userDao.getById("user2");
        System.out.println(user.toString());
    }

    @Test
    public void getAll(){
        List<User> list = userDao.getAll();
        System.out.println(list.size());
    }

    @Test
    public void countAll(){
        int total = userDao.countAll();
        Assert.assertEquals(2 , total);
    }

    @Test
    @Rollback(value = false)
    public void save(){
        User user = new User();
        user.setName("test User");
        userDao.save(user);
    }

    @Test
    @Rollback(value = false)
    public void update(){
        User user = userDao.getById("1");
        user.setName("new name:"+new Date().toString());
        userDao.update(user);
    }

    @Test
    @Rollback(value = false)
    public void delete(){
        User user = userDao.getByName("test User");
        userDao.delete(user.getUserId());
    }
}
