import com.company.crm.entity.*;
import com.company.crm.service.*;
import com.company.crm.utils.Gender;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:application-config.xml")
public class InitData extends AbstractJUnit4SpringContextTests {

    @Resource
    private DepartmentService departmentService;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private CustomerService customerService;
    @Resource
    private ContactService contactService;

    @Test
    public void initDept() {
        DataFactory dataFactory = new DataFactory();
        Department d1 = new Department();
        d1.setDeptName(dataFactory.getRandomWord().toUpperCase());
        departmentService.save(d1);
        for (int i = 0; i < 2; i++) {
            Department d2 = new Department();
            d2.setDeptName(dataFactory.getRandomWord().toUpperCase());
            d2.setParent(d1);
            departmentService.save(d2);
            for (int j = 0; j < 3; j++) {
                Department d3 = new Department();
                d3.setDeptName(dataFactory.getRandomWord().toUpperCase());
                d3.setParent(d2);
                departmentService.save(d3);
            }
        }
    }

    @Test
    public void initRole() {
        Role r1 = new Role();
        r1.setRoleKey("salesman");
        r1.setRoleValue("业务员");
        r1.setRemark("具有客户管理模块功能");
        r1.setSeq(1);
        roleService.save(r1);

        Role r2 = new Role();
        r2.setRoleKey("salesManager");
        r2.setRoleValue("业务经理");
        r2.setRemark("具有客户管理模块,报表管理功能");
        r2.setSeq(2);
        roleService.save(r2);

        Role r3 = new Role();
        r3.setRoleKey("account");
        r3.setRoleValue("财务人员");
        r3.setRemark("具有合同管理模块功能");
        r3.setSeq(3);
        roleService.save(r3);

        Role r4 = new Role();
        r4.setRoleKey("admin");
        r4.setRoleValue("管理员");
        r4.setRemark("具有系统所有功能");
        r4.setSeq(4);
        roleService.save(r4);
    }

    @Test
    public void initUser() {
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
            user.setGender(dataFactory.chance(70)? Gender.MALE:Gender.FEMALE);
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

    @Test
    public void initCustomer(){
        DataFactory dataFactory = new DataFactory();
        Customer.Level[] levels = Customer.Level.values();
        Customer.Source[] sources = Customer.Source.values();
        Customer.Status[] statuses = Customer.Status.values();
        Contact.Title[] titles = Contact.Title.values();
        List<User> userList = userService.getAll();

        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setAddress(dataFactory.getAddress());
            customer.setAddress2(dataFactory.getAddress());
            customer.setBusiness(dataFactory.getRandomWord().toUpperCase());
            customer.setFax(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
            customer.setLevel(levels[dataFactory.getNumberBetween(0,levels.length-1)]);
            customer.setName("CUSTOMER_"+dataFactory.getRandomWord().toUpperCase());
            customer.setRemark(dataFactory.getRandomText(1,30));
            customer.setSource(sources[dataFactory.getNumberBetween(0,sources.length-1)]);
            customer.setStatus(statuses[dataFactory.getNumberBetween(0,statuses.length-1)]);
            customer.setUser(userList.get(dataFactory.getNumberBetween(0,userList.size()-1)));
            customer.setWebSite("www."+dataFactory.getRandomWord().toLowerCase()+".com");

            customerService.save(customer);
            for (int j = 0; j < 4; j++) {
                Contact contact = new Contact();
                contact.setCustomer(customer);
                contact.setEmail(dataFactory.getEmailAddress());
                contact.setGender(dataFactory.chance(70)? Gender.MALE:Gender.FEMALE);
                contact.setMajor(j==0);
                contact.setMobilePhone(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
                contact.setName(dataFactory.getName());
                contact.setPhone(String.valueOf(dataFactory.getNumberBetween(100000, 999999)));
                contact.setTitle(titles[dataFactory.getNumberBetween(0,titles.length-1)]);
                contactService.save(contact);
            }
        }
    }

}
