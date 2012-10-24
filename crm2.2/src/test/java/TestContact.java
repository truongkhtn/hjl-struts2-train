import com.company.crm.action.Pager;
import com.company.crm.entity.Contact;
import com.company.crm.entity.Customer;
import com.company.crm.service.ContactService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:application-config.xml")
public class TestContact extends AbstractJUnit4SpringContextTests {

    @Resource
    private ContactService contactService;

    @Test
    public void getByCustomerId(){
        List<Contact> list = contactService.getByCustomerId("089050ee-dbd0-47e7-ac18-0193b8620a48");
        Assert.assertNotNull(list);
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void getMajorByCustomerId(){
        Contact contact = contactService.getMajorByCustomerId("089050ee-dbd0-47e7-ac18-0193b8620a48");
        Assert.assertNotNull(contact);
    }

    @Test
    public void testGetPager(){
        Contact contact = new Contact();
        contact.setPhone("");
//        contact.setPhone("128955");
        contact.setMobilePhone("");
//        contact.setMobilePhone("520472");
//        contact.setMobilePhone("20");
        contact.setName("");
//        contact.setName("Chester");

        Customer customer = new Customer();
        customer.setName("CUSTOMER");
//        customer.setName("DAD");
        customer.setAddress("");
//        customer.setAddress("Race");

        contact.setCustomer(customer);
        Pager pager = contactService.getByPager(null,contact);
        System.out.println(pager);
    }

}
