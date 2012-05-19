import com.company.travel.entity.Group;
import com.company.travel.entity.MessageCategory;
import com.company.travel.entity.User;
import com.company.travel.service.GroupService;
import com.company.travel.service.MessageCategoryService;
import com.company.travel.service.UserService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * 初始系统数据，资源表，角色表，用户表
 */

@ContextConfiguration(value = {"classpath:application-config.xml"})
//@Ignore
public class InitData extends AbstractTransactionalJUnit4SpringContextTests {

    @javax.annotation.Resource
    private UserService userService;
    @javax.annotation.Resource
    private GroupService groupService;
    @Resource
    private MessageCategoryService messageCategoryService;


    @Test
    public void simple() {
    }

    @Test
    @Rollback(value = false)
    public void initUser() {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        userService.save(user1);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword("user");
        userService.save(user2);
    }

    @Test
    @Rollback(value = false)
    public void initGroup() {
        groupService.save(new Group("全体" , 0));
        groupService.save(new Group("组别A" , 1));
        groupService.save(new Group("组别B" , 2));
        groupService.save(new Group("组别C" , 3));
        groupService.save(new Group("组别D" , 4));
    }

    @Test
    @Rollback(value = false)
    public void initMessageCategory() {
        messageCategoryService.save(new MessageCategory("假期" , 0));
        messageCategoryService.save(new MessageCategory("通知" , 1));
        messageCategoryService.save(new MessageCategory("其它A" , 2));
        messageCategoryService.save(new MessageCategory("其它B" , 3));
        messageCategoryService.save(new MessageCategory("其它C" , 4));
    }


//    @Test
//    @Rollback(value = false)
//    public void initUser2Role() {
//        Role role1 = roleService.get("name", "管理员");
//        Role role2 = roleService.get("name", "一般用户");
//        User user1 = userService.get("name", "管理员");
//
//        Set<Role> roleSet = new HashSet<Role>();
//        roleSet.add(role1);
//        roleSet.add(role2);
//
//        user1.setRoleSet(roleSet);
//        userService.update(user1);
//    }

}
