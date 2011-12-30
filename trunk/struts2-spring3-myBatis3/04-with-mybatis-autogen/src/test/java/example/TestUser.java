package example;


import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.entity.UserExample;
import cn.com.oceansoft.struts2.service.UserService;
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
    private UserService userService;

    @Test
    @Ignore
    public void simple(){
    }

    @Test
    @Ignore
    public void getById(){
        User user = userService.getById("1");
        Assert.assertEquals("aaa" , user.getUserName());
    }

    @Test
    public void getAll(){
        List<User> list = userService.getAll();
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void countAll(){
        int total = userService.countAll();
        Assert.assertEquals(2 , total);
    }

    @Test
    @Rollback(value = false)
    public void save(){
        User user = new User();
        user.setUserName("test User");
        user.setBirthday(new Date());
        userService.save(user);
    }

    @Test
    @Rollback(value = false)
    public void update(){
        User user = userService.getById("1");
        user.setUserName("new name:" + new Date().toString());
        userService.update(user);
    }

    @Test
    @Rollback(value = false)
    public void delete(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo("test User");
        User user = userService.getByExample(userExample);
        userService.delete(user.getUserId());
    }

}
