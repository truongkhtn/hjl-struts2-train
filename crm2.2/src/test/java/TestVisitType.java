import com.company.crm.entity.VisitType;
import com.company.crm.service.VisitRecordService;
import com.company.crm.service.VisitTypeService;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration("classpath:application-config.xml")
public class TestVisitType extends AbstractJUnit4SpringContextTests {

    @Resource
    private VisitTypeService visitTypeService;

}
