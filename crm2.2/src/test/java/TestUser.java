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
    public void testSaveUserHardCode(){
        Role admin = roleService.get("value" , "admin");
        saveByNameAndRole("admin" , admin);

        Role salesman = roleService.get("value" , "salesman");
        saveByNameAndRole("sales" , salesman);

        Role salesManager = roleService.get("value" , "salesManager");
        saveByNameAndRole("manager" , salesManager);

        Role account = roleService.get("value" , "account");
        saveByNameAndRole("account" , account);
    }

    private void saveByNameAndRole(String name , Role role){
         DataFactory dataFactory = new DataFactory();
         List<Department> departmentList = departmentService.getAll();

        User user = new User();
        user.getRoleSet().add(role);
        user.setEmpNo("EMP" + name.toUpperCase());
        user.setUsername(name);
        user.setPassword(name);
        user.setRealName(name.toUpperCase());
        user.setDept(departmentList.get(dataFactory.getNumberBetween(0, departmentList.size() - 1)));
        user.setBirthDate(dataFactory.getBirthDate());
        user.setGender(dataFactory.chance(70) ? Gender.MALE : Gender.FEMALE);
        user.setMaxCustomer(dataFactory.getNumberBetween(30, 60));
        user.setRemarks(dataFactory.getRandomText(1, 30));
        user.setValid(true);
        user.setTelephone(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
        userService.save(user);
    }

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
            user.setGender(dataFactory.chance(70)? Gender.MALE: Gender.FEMALE);
            user.setMaxCustomer(dataFactory.getNumberBetween(30,60));
            user.setUsername("user" + (i + 1));
            user.setPassword(dataFactory.getRandomWord().toLowerCase());
            user.setRealName(dataFactory.getName());
            user.setRemarks(dataFactory.getRandomText(1, 30));
            user.setValid(dataFactory.chance(50));
            user.setTelephone(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
            userService.save(user);
        }
    }

    @Test
    public void testLogin(){
        User user = userService.getByLogin("admin" , "admin");
        Assert.assertNotNull(user);
    }

}
