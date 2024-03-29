import com.company.travel.ws.WsUserService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import javax.annotation.Resource;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class TestWsUser extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private WsUserService wsUserService;

    @Test
    @Rollback(value = false)
    public void testSavePublicUser() {
        wsUserService.register();
    }

}
