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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ContextConfiguration({"classpath:application-config.xml"})
public class TestUserDynamicSQL extends AbstractTransactionalJUnit4SpringContextTests{

    @Resource
    private UserService userService;

    //动态sql用例 -- if
    @Test
    public void getActiveUserByNameLike(){
        User user = new User();
        List<User> list = userService.getActiveUserByNameLike(user);
        Assert.assertEquals(4, list.size());

        user.setName("an");
        list = userService.getActiveUserByNameLike(user);
        Assert.assertEquals(1, list.size());
    }

    //动态sql用例 -- choose
    @Test
    public void getActiveUserLike(){
        User user = new User();
//        user.setName("an");
//        user.setEmail("sam");

        List list = userService.getActiveUserLike(user);
        System.out.println(list.size());
    }

    //动态sql用例 -- where
    @Test
    public void getUserLike(){
        User user = new User();
        user.setName("s");
        user.setState("ACTIVE");
        user.setEmail("@");
        List list = userService.getUserLike(user);
        System.out.println(list.size());
    }

    //动态sql用例 -- foreach
    @Test
    public void getByIds(){
        List<String> ids = new ArrayList<String>();
        ids.add("user01");
        ids.add("user02");
        ids.add("user03");
        List userList = userService.getByIds(ids);
        System.out.println(userList.size());
    }

    //动态sql用例 -- set
    @Test
    @Rollback(value = false)
    public void updateIfNecessary(){
        User user = new User();
        user.setUserId("user01");
//        user.setName("updated name...");
        userService.update(user);
    }

}
