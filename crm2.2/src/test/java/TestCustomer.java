import com.company.crm.action.Pager;
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

    @Test
    public void testServe(){
        User user = userService.get("b0378a6e-7eb8-4674-824d-52264ddc1cf8");
        Pager pager = contactService.getServeByUser(null,user);
        System.out.println( pager.getList().size());
    }

}
