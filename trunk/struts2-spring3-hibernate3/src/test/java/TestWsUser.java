import com.company.travel.entity.Group;
import com.company.travel.entity.User;
import com.company.travel.service.GroupService;
import com.company.travel.service.UserService;
import com.company.travel.utils.StringGenerator;
import com.company.travel.ws.WsUserService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class TestWsUser extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserService userService;
    @Resource
    private GroupService groupService;

    @Test
    @Rollback(value = false)
    public void testSavePublicUser() {
         User publicUser = new User();
        String random = StringGenerator.getRandomString("public", 6);
        publicUser.setUsername(random);
        publicUser.setPassword("");
        publicUser.setRealname(random);

        //public 账户默认加入 组别A，组别B，组别C
        Group groupA = groupService.get("name" ,"组别A");
        Group groupB = groupService.get("name" ,"组别B");
        Group groupC = groupService.get("name" ,"组别C");
        Set<Group> groupSet = new HashSet<Group>();
        groupSet.add(groupA);
        groupSet.add(groupB);
        groupSet.add(groupC);

        publicUser.setGroupSet(groupSet);
        userService.save(publicUser);
    }

}
