import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Calendar;
import java.util.Date;

@ContextConfiguration("classpath:application-config.xml")
public class TestDDL extends AbstractJUnit4SpringContextTests {

    @Test
    public void simple(){
    }

    @Test
    public void testDate(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,2012);
        c.set(Calendar.MONTH,0);
        c.set(Calendar.DATE,1);
        Date d = c.getTime();
        Date d2 = new Date();
        d2.setTime(new Long("1325383441272"));
//        System.out.println(d2.getTime());
        System.out.println(d2.toLocaleString());
    }

}
