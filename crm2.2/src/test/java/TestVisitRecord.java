import com.company.crm.entity.*;
import com.company.crm.service.*;
import com.company.crm.utils.Level;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@ContextConfiguration("classpath:application-config.xml")
public class TestVisitRecord extends AbstractJUnit4SpringContextTests{

    @Resource
    private VisitRecordService visitRecordService;
    @Resource
    private CustomerService customerService;
    @Resource
    private ContactService contactService;
    @Resource
    private UserService userService;
    @Resource
    private VisitTypeService visitTypeService;

    @Test
    public void testGetByCustomerId(){
        String id = "1d7f92d3-a88b-4b17-956b-7cdb06f43b4b";
        List<VisitRecord> list = visitRecordService.getList("customer.id", id);
        System.out.println(list.size());
    }

}
