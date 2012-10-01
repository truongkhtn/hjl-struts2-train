import com.company.crm.entity.*;
import com.company.crm.service.*;
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
    public void initVisitRecord(){
        DataFactory dataFactory = new DataFactory();
        List<Customer> customerList = customerService.getAll();
        List<VisitType> visitTypeList = visitTypeService.getAll();

        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            List<Contact> contactList = contactService.getByCustomerId(customer.getId());

            for (int j = 0; j < 5; j++) {
                VisitRecord vr = new VisitRecord();
                vr.setContact(contactList.get(dataFactory.getNumberBetween(0,3)));
                vr.setCustomer(customer);
                vr.setFirstVisit(j==0);
                vr.setOwner(customer.getOwner());
                Date minDate = new Date();
                minDate.setTime(new Long("1325383441272"));
                vr.setVisitDate(dataFactory.getDateBetween(minDate, new Date()));
                vr.setVisitType(visitTypeList.get(dataFactory.getNumberBetween(0,visitTypeList.size()-1)));
                visitRecordService.save(vr);
            }
        }
    }

}
