import com.company.travel.ws.WsMessageService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class TestWsMessage extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private WsMessageService wsMessageService;

    @Test
    @Rollback(value = false)
    public void testSavePublicUser() {
        wsMessageService.getMessageById("aefcf9fc-1e45-456d-a85a-13f94a42e18a");
    }

}
