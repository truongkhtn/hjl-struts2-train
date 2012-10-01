import com.company.crm.entity.*;
import com.company.crm.service.ContactService;
import com.company.crm.service.CustomerService;
import com.company.crm.service.UserService;
import com.company.crm.utils.Gender;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@ContextConfiguration("classpath:application-config.xml")
public class TestCustomer extends AbstractJUnit4SpringContextTests{

    @Resource
    private CustomerService customerService;
    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;


}
