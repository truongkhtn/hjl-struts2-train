import com.company.travel.entity.Message;
import com.company.travel.service.MessageService;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class TestMessage extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private MessageService messageService;

    @Test
    public void testGetAllByOrder(){
        List<Message> list = messageService.getAllByOrder();
        System.out.println(list.size());
    }

}
