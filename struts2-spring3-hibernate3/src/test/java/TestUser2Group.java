import com.company.travel.entity.Group;
import com.company.travel.entity.User;
import com.company.travel.service.GroupService;
import com.company.travel.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@ContextConfiguration(value = {"classpath:application-config.xml"})
@Ignore
public class TestUser2Group extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserService userService;
    @Resource
    private GroupService groupService;

    @Test
    public void simple() {
    }

    @Test
    @Rollback(value = false)
    public void saveUser2Group() {
        String[] data = {"A", "B", "C", "D"};
        for (String s : data) {
            Group group = groupService.get("name", "组别"+s);
            Set<Group> set = new HashSet<Group>();
            set.add(group);
            for (int i = 1; i < 5; i++) {
                User user = new User();
                user.setUsername(s + "0" + i);
                user.setPassword((s + "0" + i).toLowerCase());
                user.setRealname(s + "0" + i);
                user.setGroupSet(set);
                userService.save(user);
            }
        }
    }


}
