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
    public void initCustomer(){
        DataFactory dataFactory = new DataFactory();
        Customer.Level[] levels = Customer.Level.values();
        Customer.Source[] sources = Customer.Source.values();
        Customer.Status[] statuses = Customer.Status.values();
        Contact.Title[] titles = Contact.Title.values();
        List<User> userList = userService.getAll();

        for (int i = 0; i < 20; i++) {
            //init customer
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
            User user = userList.get(dataFactory.getNumberBetween(0, userList.size() - 1));
            customer.setUser(user);
            customer.setWebSite("www."+dataFactory.getRandomWord().toLowerCase()+".com");

            customerService.save(customer);
            //init contact
            Contact contact = null;
            for (int j = 0; j < 4; j++) {
                contact = new Contact();
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
            //init visitRecord
            for (int j = 0; j < 4; j++) {
                VisitRecord vr = new VisitRecord();
                vr.setContact(contact);
                vr.setCustomer(customer);
                vr.setFirstVisit(j==0);
                vr.setUser(user);
                Date minDate = new Date();
                minDate.setTime(new Long("1325383441272"));
                vr.setVisitDate(dataFactory.getDateBetween(minDate, new Date()));
                vr.setVisitType(new VisitType());


            }
        }
    }


}
