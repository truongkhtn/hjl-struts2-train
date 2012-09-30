import com.company.crm.entity.Department;
import com.company.crm.entity.Role;
import com.company.crm.entity.User;
import com.company.crm.service.DepartmentService;
import com.company.crm.service.RoleService;
import com.company.crm.service.UserService;
import org.fluttercode.datafactory.impl.DataFactory;
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
    public void testBatchSave() {
        DataFactory dataFactory = new DataFactory();
        List<Department> departmentList = departmentService.getAll();
        List<Role> roleList = roleService.getAll();
        for (int i = 0; i < 20; i++) {
            Department dept = departmentList.get(dataFactory.getNumberBetween(0, 8));
            Role role = roleList.get(dataFactory.getNumberBetween(0,3));

            User user = new User();
            user.setDept(dept);
            user.getRoleSet().add(role);
            user.setBirthDate(dataFactory.getBirthDate());
            user.setEmpNo("EMP"+(i+1));
            user.setGender(dataFactory.chance(70)? User.Gender.MALE:User.Gender.FEMALE);
            user.setMaxCustomer(dataFactory.getNumberBetween(30,60));
            user.setUsername("user" + (i + 1));
            user.setPassword(dataFactory.getRandomWord().toLowerCase());
            user.setRealName(dataFactory.getName());
            user.setRemarks(dataFactory.getRandomText(1, 30));
            user.setStatus(dataFactory.chance(50));
            user.setTelephone(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
            userService.save(user);
        }
    }
}
