import com.company.crm.service.RoleService;
import com.company.crm.service.UserService;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeFactory;

@ContextConfiguration("classpath:application-config.xml")
public class TestUserToRole extends AbstractJUnit4SpringContextTests {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @Test
    public void initUserToRole(){
        DataFactory dataFactory = new DataFactory();



    }

}
