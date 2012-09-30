import com.company.crm.service.VisitRecordService;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration("classpath:application-config.xml")
public class TestVisitRecord extends AbstractJUnit4SpringContextTests{

    @Resource
    private VisitRecordService visitRecordService;

    @Test
    public void initVisitRecord(){
        DataFactory dataFactory = new DataFactory();

        for (int i = 0; i < 200; i++) {

        }

    }

}
