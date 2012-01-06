package example;


import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.service.UserService;
import cn.com.oceansoft.struts2.utils.UuidUtil;
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
    @Rollback(value = false)
    public void initDate(){
        userService.deleteAll();
        userService.save(new User("user01","Jack" , "1","ACTIVE","jack@123.com"));
        userService.save(new User("user02","Sam" , "1","ACTIVE","sam@123.com"));
        userService.save(new User("user03","Anna" , "0","ACTIVE","anna@123.com"));
        userService.save(new User("user04","Mike" , "1","DEACTIVE","mike@123.com"));
        userService.save(new User("user05","David" , "1","ACTIVE","david@123.com"));
    }

    @Test
    @Ignore
    public void getById(){
        User user = userService.getById("1");
        Assert.assertEquals("aaa" , user.getName());
    }

    @Test
    public void getAll(){
        List<User> list = userService.getAll();
        Assert.assertEquals(5, list.size());
    }

    @Test
    public void countAll(){
        int total = userService.countAll();
        Assert.assertEquals(5 , total);
    }

    @Test
    public void save(){
        User user = new User();
        user.setUserId(UuidUtil.genUuid());
        user.setName("test User");
        userService.save(user);
    }

    @Test
    @Ignore
    public void update(){
        User user = userService.getById("1");
        user.setName("new name:"+new Date().toString());
        userService.update(user);
    }

    @Test
    public void delete(){
        User user = userService.getByName("Jack");
        userService.delete(user.getUserId());
    }

}
