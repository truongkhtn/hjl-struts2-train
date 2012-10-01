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

    @Test
    public void initVisitType(){
        VisitType vt1 = new VisitType();
        vt1.setValue("home");
        vt1.setName("上门拜访");
        vt1.setReq(1);
        vt1.setValid(true);
        visitTypeService.save(vt1);

        VisitType vt2 = new VisitType();
        vt2.setValue("telephone");
        vt2.setName("电话拜访");
        vt2.setReq(2);
        vt2.setValid(true);
        visitTypeService.save(vt2);

        VisitType vt3 = new VisitType();
        vt3.setValue("email");
        vt3.setName("邮件拜访");
        vt3.setReq(3);
        vt3.setValid(true);
        visitTypeService.save(vt3);

        VisitType vt4 = new VisitType();
        vt4.setValue("fax");
        vt4.setName("传真");
        vt4.setReq(4);
        vt4.setValid(true);
        visitTypeService.save(vt4);

        VisitType vt5 = new VisitType();
        vt5.setValue("message");
        vt5.setName("短信");
        vt5.setReq(5);
        vt5.setValid(true);
        visitTypeService.save(vt5);

        VisitType vt6 = new VisitType();
        vt6.setValue("walk_in");
        vt6.setName("客户上门");
        vt6.setReq(6);
        vt6.setValid(true);
        visitTypeService.save(vt6);
    }
    
}
