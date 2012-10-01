import com.company.crm.entity.Contact;
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

}
