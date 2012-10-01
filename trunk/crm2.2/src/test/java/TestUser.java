import com.company.crm.entity.Department;
import com.company.crm.entity.Role;
import com.company.crm.entity.User;
import com.company.crm.service.DepartmentService;
import com.company.crm.service.RoleService;
import com.company.crm.service.UserService;
import com.company.crm.utils.Gender;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:application-config.xml")
public class TestUser extends AbstractJUnit4SpringContextTests {

    @Resource
    private DepartmentService departmentService;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @Test
    public void testLogin(){
        User user = userService.getByLogin("admin" , "admin");
        Assert.assertNotNull(user);
    }

}
