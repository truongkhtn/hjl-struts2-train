package example;


import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import javax.annotation.Resource;

@ContextConfiguration({"classpath:application-config.xml"})
public class TestUser extends AbstractTransactionalJUnit4SpringContextTests{

    @Resource
    private UserService userService;

    @Test
    public void simple(){
    }

    @Test
    public void getById(){
        User user = userService.getById("1");
        Assert.assertEquals("aaa" , user.getName());
    }

}
