import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:application-config.xml")
public class TestDDL extends AbstractJUnit4SpringContextTests {

    @Test
    public void simple(){
    }

}
