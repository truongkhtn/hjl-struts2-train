import com.company.travel.entity.Resource;
import com.company.travel.entity.Role;
import com.company.travel.entity.User;
import com.company.travel.service.ResourceService;
import com.company.travel.service.RoleService;
import com.company.travel.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.HashSet;
import java.util.Set;


/**
 * 初始系统数据，资源表，角色表，用户表
 */

@ContextConfiguration(value = {"classpath:application-config.xml"})
//@Ignore
public class InitData extends AbstractTransactionalJUnit4SpringContextTests {

    @javax.annotation.Resource
    private UserService userService;
    @javax.annotation.Resource
    private RoleService roleService;
    @javax.annotation.Resource
    ResourceService resourceService;

    @Test
    public void simple() {

    }

    @Test
    @Rollback(value = false)
    public void initResource() {
        Resource resource1 = new Resource();
        resource1.setIsSystem(true);
        resource1.setDescription("普通资源001");
        resource1.setName("test001");
        resource1.setValue("test001");
        resourceService.save(resource1);

        Resource resource2 = new Resource();
        resource2.setIsSystem(false);
        resource2.setDescription("管理资源002");
        resource2.setName("test002");
        resource2.setValue("test002");
        resourceService.save(resource2);

        Resource resource3 = new Resource();
        resource3.setIsSystem(true);
        resource3.setDescription("测试资源003");
        resource3.setName("/test");
        resource3.setValue("ROLE_ADMIN");
        resourceService.save(resource3);
    }

    @Test
    @Rollback(value = false)
    public void initRole() {
        Role role1 = new Role();
        role1.setName("管理员");
        role1.setDescription("所有权限");
        role1.setValue("ROLE_ADMIN");
        role1.setIsSystem(true);
        role1.setProjectId("proj");
        roleService.save(role1);

        Role role2 = new Role();
        role2.setName("一般用户");
        role2.setDescription("普通用户");
        role2.setValue("ROLE_USER");
        role2.setIsSystem(true);
        role2.setProjectId("proj");
        roleService.save(role2);
    }

    @Test
    @Rollback(value = false)
    public void initUser() {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        user1.setName("管理员");
        user1.setEmail("admin@123.com");
        user1.setIsAccountEnabled(true);
        user1.setIsAccountLocked(false);
        user1.setIsAccountExpired(false);
        user1.setIsCredentialsExpired(false);
        user1.setLoginFailureCount(0);
        user1.setArea("ADMIN");
        user1.setCellPhone("13956895623");
        user1.setCompanyName("admin company");
        user1.setFax("010-89565689");
        user1.setPhone("021-66668888");
        userService.save(user1);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword("user");
        user2.setName("普通用户");
        user2.setEmail("test email");
        user2.setIsAccountEnabled(false);
        user2.setIsAccountLocked(false);
        user2.setIsAccountExpired(false);
        user2.setIsCredentialsExpired(false);
        user2.setLoginFailureCount(0);
        user2.setArea("CS");
        user2.setCellPhone("13956895623");
        user2.setCompanyName("user company ");
        user2.setFax("010-89565689");
        user2.setPhone("021-66668888");
        userService.save(user2);
    }

    @Test
    @Rollback(value = false)
    public void initUser2Role() {
        Role role1 = roleService.get("name", "管理员");
        Role role2 = roleService.get("name", "一般用户");
        User user1 = userService.get("name", "管理员");

        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(role1);
        roleSet.add(role2);

        user1.setRoleSet(roleSet);
        userService.update(user1);
    }

    @Test
    @Rollback(value = false)
    public void initRole2Res() {
        Resource resource1 = resourceService.get("name" , "test001");
        Resource resource2 = resourceService.get("name" , "test002");

        Role role1 = roleService.get("name", "管理员");
        Role role2 = roleService.get("name", "一般用户");

        Set<Resource> resourceSet1 = new HashSet<Resource>();
        resourceSet1.add(resource1);

        Set<Resource> resourceSet2 = new HashSet<Resource>();
        resourceSet2.add(resource1);
        resourceSet2.add(resource2);

        role1.setResourceSet(resourceSet2);
        role2.setResourceSet(resourceSet1);

        roleService.update(role1);
        roleService.update(role2);
    }


}
